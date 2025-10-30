package com.muxia.bookstore.service;

import com.muxia.bookstore.pojo.CartItem;
import com.muxia.bookstore.pojo.User;

import java.util.List;

public interface CartItemService {
    // 根据用户获取 用户的商品列表
    List<CartItem> getCartItemList(User user);

    // 在购物袋中 更新书本信息
    void updateCartItem(CartItem cartItem);

    // 在购物车中 添加购物袋信息
    void addCartItem(CartItem cartItem);
}
