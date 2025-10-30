package com.muxia.bookstore.service.impl;

import com.muxia.bookstore.dao.CartItemDao;
import com.muxia.bookstore.pojo.Book;
import com.muxia.bookstore.pojo.CartItem;
import com.muxia.bookstore.pojo.User;
import com.muxia.bookstore.service.BookService;
import com.muxia.bookstore.service.CartItemService;

import java.util.List;

public class CartItemServiceImpl implements CartItemService {
    private CartItemDao cartItemDao;
    private BookService bookService;

    // 获取 cartItem 列表
    @Override
    public List<CartItem> getCartItemList(User user) {
        List<CartItem> cartItemList = cartItemDao.getCartItemListByUserId(user.getId());
        // 遍历 cartItemList
        cartItemList.forEach(cartItem -> {
            // 获取书信息
            Integer bookId = cartItem.getBook().getId();
            Book book = bookService.getBook(bookId);
            // 把书的信息填充到 cartItem 上
            cartItem.setBook(book);

        });
        return cartItemList;
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartItemDao.updateCartItem(cartItem);
    }

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }
}
