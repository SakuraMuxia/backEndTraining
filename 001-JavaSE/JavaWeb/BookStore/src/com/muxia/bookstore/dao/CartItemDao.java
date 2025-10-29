package com.muxia.bookstore.dao;

// 获取 用户商品 列表

import com.muxia.bookstore.pojo.CartItem;

import java.util.List;

public interface CartItemDao {
    // 根据用户ID获取 用户的购物车商品
    List<CartItem> getCartItemListByUserId(Integer userId);
}
