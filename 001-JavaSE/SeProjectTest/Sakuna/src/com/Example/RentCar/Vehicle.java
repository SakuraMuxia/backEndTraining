package com.Example.RentCar;

// 机动车父类
public abstract class Vehicle {
    private String brand;
    private String vehicleId;
    private double dayRent;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public double getDayRent() {
        return dayRent;
    }

    public void setDayRent(double dayRent) {
        this.dayRent = dayRent;
    }

    public Vehicle(String brand, String vehicleId, double dayRent) {
        this.brand = brand;
        this.vehicleId = vehicleId;
        this.dayRent = dayRent;
    }

    public Vehicle() {

    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", vehicleId='" + vehicleId + '\'' +
                ", dayRent=" + dayRent +
                '}';
    }

    // 计算租金
    public abstract double getPrice(int days);
}
