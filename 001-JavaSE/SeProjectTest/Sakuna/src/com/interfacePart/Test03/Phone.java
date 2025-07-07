package com.interfacePart.Test03;

public abstract class Phone {
    // 定义属性
    private String brand;
    private String type;
    private double price;
    // 封装

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Phone() {
    }

    public Phone(String brand, String type, double price) {
        this.brand = brand;
        this.type = type;
        this.price = price;
    }

    // 定义抽象方法
    public abstract void call();
    public abstract void sendMessage(String message);

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
