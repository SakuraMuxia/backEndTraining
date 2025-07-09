package com.Example.RentCar;

import java.util.Scanner;

public class TestVehicle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎使用此系统~~~");
        System.out.println("输入汽车类型： 1.轿车 2.客车");
        // 输入选择
        int choice = input.nextInt();

        String brand = ""; // 用于保存用户选择的品牌
        String type = "";// 用于保存用户选择的型号
        int seatCount = 0; // 用于保存用户选择的座位数

        if(choice == 1){
            // 轿车
            System.out.println("请选择汽车品牌：1.奔驰 2.宝马");
            brand = input.nextInt() == 1 ? "奔驰" : "宝马";
            if(brand.equals("奔驰")){
                System.out.println("请选择汽车型号：1.  S500  2.  S600");
                type = input.nextInt() == 1 ? "S500" : "S600";
            }else{
                System.out.println("请选择汽车型号：1.  X5  2.  740Li");
                type = input.nextInt() == 1 ? "X5" : "740Li";
            }
        }else{
            // 客车
            System.out.println("请选择汽车品牌：1.金杯    2.比亚迪");
            brand = input.nextInt() == 1 ? "金杯" : "比亚迪";
            System.out.println("请选择汽车座位数：1.  16座  2.  34座");
            seatCount = input.nextInt() == 1 ? 16 : 34;
        }

        // 获取到了用户选择的汽车信息
        System.out.println("品牌:" + brand);
        System.out.println("型号:" + type);
        System.out.println("座位数:" + seatCount);

        // 创建汽车操作类对象
        VehicleOperation vehicleOperation = new VehicleOperation();
        // 通过选择的品牌 类型 座位数 获取机动车对象
        Vehicle vehicle = vehicleOperation.getVehicle(brand,type,seatCount);
        //
        System.out.println("请输入租赁天数：");
        int days = input.nextInt();
        // 计算价格
        double price = vehicle.getPrice(days);
        // 打印租车结果
        System.out.println("分配跟您的车牌号为：" + vehicle.getVehicleId());
        System.out.println("您应该支付的租金为：" + price);
    }
}
