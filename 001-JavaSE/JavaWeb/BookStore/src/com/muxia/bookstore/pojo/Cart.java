package com.muxia.bookstore.pojo;


import java.util.HashMap;
import java.util.Map;
// 购物车
public class Cart {
    // 每一个 CartItem 相当于一个购物袋, 这些袋子放在购物车中
    // 袋子上贴上标签，key指向图书Id，value指向图书。
    // 定义一个 Map集合存放图书集合
    private Integer id;
    private Map<Integer,CartItem> cartItemMap = new HashMap<>();
    private Integer totalCount = 0 ;//总商品数量
    private Double totalMoney = 0.0;//总商品金额

    public Cart() {
    }

    public Cart(Integer id) {
        this.id = id;
    }

    public Cart(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
