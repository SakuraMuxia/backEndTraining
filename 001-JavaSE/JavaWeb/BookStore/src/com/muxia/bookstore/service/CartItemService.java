package com.muxia.bookstore.service;

import com.muxia.bookstore.pojo.CartItem;
import com.muxia.bookstore.pojo.User;

import java.util.List;

public interface CartItemService {
    // 根据用户获取 用户的商品列表
    List<CartItem> getCartItemList(User user);
}
