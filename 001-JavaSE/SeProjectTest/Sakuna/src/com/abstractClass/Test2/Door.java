package com.abstractClass.Test2;

public abstract class Door {
    private String brand;
    private double price;

    public Door(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public Door() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // 定义抽象方法
    public abstract  void open();

    public abstract void close();

    // toString重写

    @Override
    public String toString() {
        return "Door{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
