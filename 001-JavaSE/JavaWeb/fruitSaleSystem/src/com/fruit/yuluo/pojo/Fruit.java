package com.fruit.yuluo.pojo;

import java.math.BigDecimal;

public class Fruit {
    // 私有属性
    private Integer id;
    private String fname;
    private BigDecimal price; // 用 BigDecimal 存金额
    private Integer count;
    private String remark;

    public Fruit() {
    }

    public Fruit(Integer id, String fname, BigDecimal price, Integer count, String remark) {
        this.id = id;
        this.fname = fname;
        this.price = price;
        this.count = count;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer fcount) {
        this.count = fcount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", price=" + price +
                ", fcount=" + count +
                ", remark='" + remark + '\'' +
                '}';
    }
}
