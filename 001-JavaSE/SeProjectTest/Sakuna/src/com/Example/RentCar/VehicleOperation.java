package com.Example.RentCar;

// 机动车 操作类
public class VehicleOperation {
    // 定义静态属性
    static Vehicle [] vehicles = new Vehicle[8];

    // 定义静态代码块，加载类时自动执行。
    static{
        vehicles[0] = new Car("宝马", "粤A88888", 888, "X5");
        vehicles[1] = new Car("宝马", "粤A99999", 666, "740 Li");
        vehicles[2] = new Car("奔驰", "粤A12345", 456, "S500");
        vehicles[3] = new Car("奔驰", "粤A98765", 950, "S600");

        vehicles[4] = new Bus("金杯", "粤B11111", 888, 16);
        vehicles[5] = new Bus("金杯", "粤A22222", 666, 34);
        vehicles[6] = new Bus("比亚迪", "粤A3333", 456, 16);
        vehicles[7] = new Bus("比亚迪", "粤A55555", 950, 34);
    }

    // 根据参数返回 机动车
    public Vehicle getVehicle(String brand,String type,int seatCount){
        // 遍历数组
        for(int i = 0;i < vehicles.length;i++){
            // 汽车类型
            if(vehicles[i] instanceof Car){
                // 多态向下转型
                Car car = (Car)vehicles[i];
                // 匹配到汽车
                if(brand.equals(car.getBrand()) && type.equals(car.getType())){
                    return car;
                }
            }else{
                Bus bus = (Bus)vehicles[i];
                // 匹配到大巴
                if(brand.equals(bus.getBrand()) && seatCount == bus.getSeatCount()){
                    return bus;
                }
            }
        }
        // 否则没找到则返回null
        return null;
    }
}
