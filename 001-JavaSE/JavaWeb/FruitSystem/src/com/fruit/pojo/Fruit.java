package com.fruit.pojo;

import java.math.BigDecimal;

public class Fruit {
    // 私有属性
    private Integer id;
    private String fname;
    private BigDecimal price; // 用 BigDecimal 存金额
    private Integer fcount;
    private String remark;

    public Fruit() {
    }

    public Fruit(Integer id, String fname, BigDecimal price, Integer fcount, String remark) {
        this.id = id;
        this.fname = fname;
        this.price = price;
        this.fcount = fcount;
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

    public Integer getFcount() {
        return fcount;
    }

    public void setFcount(Integer fcount) {
        this.fcount = fcount;
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
                ", fcount=" + fcount +
                ", remark='" + remark + '\'' +
                '}';
    }
}
