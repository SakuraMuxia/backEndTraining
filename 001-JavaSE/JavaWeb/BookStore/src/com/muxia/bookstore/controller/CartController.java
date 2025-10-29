package com.muxia.bookstore.controller;

import com.muxia.bookstore.pojo.User;
import com.muxia.bookstore.service.CartItemService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class CartController {
    private CartItemService cartService;
    // 添加到购物车
    public String addToCart(Integer id, HttpSession session, HttpServletResponse resp) throws IOException {
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
            cartService.getCartItemList(user);

            return null;
        }
    }
}
