package com.muxia.bookstore.dao.impl;

import com.muxia.bookstore.dao.CartItemDao;
import com.muxia.bookstore.myssm.dao.BaseDao;
import com.muxia.bookstore.pojo.CartItem;

import java.util.List;

public class CartItemDaoImpl extends BaseDao<CartItem> implements CartItemDao {
    @Override
    public List<CartItem> getCartItemListByUserId(Integer userId) {
        return executeQuery("select * from t_cart where user = ? " , userId);
    }
}
