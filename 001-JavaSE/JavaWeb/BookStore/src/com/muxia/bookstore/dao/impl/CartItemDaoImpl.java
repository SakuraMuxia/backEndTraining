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

    @Override
    public void updateCartItem(CartItem cartItem) {
        String sql = "update t_cart set buyCount = ? where id = ?";
        executeUpdate(sql,cartItem.getBuyCount(),cartItem.getId());
    }

    @Override
    public void addCartItem(CartItem cartItem) {
        Integer id = cartItem.getBook().getId();
        String bookName = cartItem.getBookName();
        Double price = cartItem.getPrice();
        Integer buyCount = cartItem.getBuyCount();
        Integer id1 = cartItem.getUser().getId();
        String sql = "insert into t_cart values (0,?,?,?,?,?)";
        executeUpdate(sql,id,bookName,price,buyCount,id1);
    }
}
