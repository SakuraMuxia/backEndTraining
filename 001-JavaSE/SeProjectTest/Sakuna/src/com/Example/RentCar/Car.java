package com.Example.RentCar;

public class Car extends Vehicle{
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Car(String brand, String vehicleId, double dayRent, String type) {
        super(brand, vehicleId, dayRent);
        this.type = type;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                '}';
    }

    @Override
    public double getPrice(int days) {
        double price = 0;
        if(days > 150){
            price = this.getDayRent() * days * 0.7;
        }else if(days > 30){
            price = this.getDayRent() * days * 0.8;
        }else if(days > 7){
            price = this.getDayRent() * days * 0.9;
        }else{
            price = this.getDayRent() * days;
        }
        return price;
    }
}
