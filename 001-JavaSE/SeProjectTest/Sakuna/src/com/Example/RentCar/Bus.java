package com.Example.RentCar;

public class Bus extends Vehicle{
    private int seatCount;

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public Bus(String brand, String vehicleId, double dayRent, int seatCount) {
        super(brand, vehicleId, dayRent);
        this.seatCount = seatCount;
    }

    public Bus() {
    }

    @Override
    public String toString() {
        return "Bus{" +
                "seatCount=" + seatCount +
                '}';
    }

    @Override
    public double getPrice(int days) {
        double price = 0;
        if(days >= 150){
            price = this.getDayRent() * days * 0.6;
        }else if(days >= 30){
            price = this.getDayRent() * days * 0.7;
        }else if(days >= 7){
            price = this.getDayRent() * days * 0.8;
        }else if(days >= 3){
            price = this.getDayRent() * days * 0.9;
        }else{
            price = this.getDayRent() * days;
        }
        return price;
    }

}
