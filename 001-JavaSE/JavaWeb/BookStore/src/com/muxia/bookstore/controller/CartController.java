package com.muxia.bookstore.controller;

import com.muxia.bookstore.pojo.Book;
import com.muxia.bookstore.pojo.Cart;
import com.muxia.bookstore.pojo.CartItem;
import com.muxia.bookstore.pojo.User;
import com.muxia.bookstore.service.BookService;
import com.muxia.bookstore.service.CartItemService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartController {
    private CartItemService cartItemService;
    private BookService bookService;

    // 添加到购物车
    public String addToCart(Integer bookId, HttpSession session, HttpServletResponse resp) throws IOException {
        // 获取当前用户信息
        Object currUser = session.getAttribute("currUser");
        // 判断是否登陆
        if (currUser == null){
            // 设置响应编码
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=utf-8");
            // 创建一个写入流，返回给客户端
            PrintWriter writer = resp.getWriter();
            writer.println("<script>alert('请先登录！');window.location.href='page?page=user/login';</script>");
            writer.flush();
            writer.close();
            return null;
        }else{
            User user = (User)currUser;
            // 获取用户的 商品列表
            List<CartItem> cartItemList = cartItemService.getCartItemList(user);
            // 创建一个Map集合用于保存用户的购物车列表
            Map<Integer,CartItem> cartItemMap = new HashMap<>();
            // cartItemList添加到cartItemMap集合中
            // key 指向 图书Id，value指向购物袋子
            cartItemList.forEach(cartItem -> {
                cartItemMap.put(cartItem.getBook().getId(),cartItem);
            });
            // 创建一个购物车对象
            Cart cart = new Cart(cartItemMap);
            // 绑定购物车信息到user对象上
            user.setCart(cart);

            // 执行添加 书 到购物车逻辑，当购物车中包含了 当前书本，则数量加1，否则添加一个新的书本对象到Map集合中
            if (cartItemMap.containsKey(bookId)){
                // 执行更新操作
                // 获取书本信息
                CartItem cartItem = cartItemMap.get(bookId);
                cartItem.setBuyCount(cartItem.getBuyCount() + 1);
                // 更新购物袋信息到数据库t_cart表中
                cartItemService.updateCartItem(cartItem);
            }else{
                // 执行添加操作,首先获取图书信息
                Book book = bookService.getBook(bookId);
                // 创建 一个 cartItem 对象
                CartItem cartItem = new CartItem(book,book.getBookName(),book.getPrice(),1,user);
                // 把 cartItem 这个信息添加到 数据库t_cart表中
                cartItemService.addCartItem(cartItem);
            }
            // 重定向到 购物车列表 的 list 方法中
            return "redirect:cart.do";
        }
    }
    // 展示购物车列表方法
    public String list(HttpSession session,HttpServletResponse resp){
        // 获取用户信息
        Object currUser = session.getAttribute("currUser");
        // 判断是否登陆
        if (currUser == null){
            // 设置响应编码
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=utf-8");
            // 创建一个写入流，返回给客户端
            PrintWriter writer = null;
            try {
                writer = resp.getWriter();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            writer.println("<script>alert('请先登录！');window.location.href='page?page=user/login';</script>");
            writer.flush();
            writer.close();
            return null;
        }else{
            User user = (User)currUser;
            // 获取用户的 商品列表
            List<CartItem> cartItemList = cartItemService.getCartItemList(user);
            // 创建一个Map集合用于保存用户的购物车列表
            Map<Integer,CartItem> cartItemMap = new HashMap<>();
            // cartItemList添加到cartItemMap集合中
            // key 指向 图书Id，value指向购物袋子
            cartItemList.forEach(cartItem -> {
                cartItemMap.put(cartItem.getBook().getId(),cartItem);
            });
            // 创建一个购物车对象
            Cart cart = new Cart(cartItemMap);
            // 绑定购物车信息到user对象上
            user.setCart(cart);
            // 转发页面到 购物车页面
            return "cart/cart";
        }
    }
}
