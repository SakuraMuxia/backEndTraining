package com.insideClassPart;

// 测试静态内部类
public class Test02 {
    public static void main(String[] args) {
        // 只要访问权限允许，可以通过类名直接访问静态内部类中方法或创建对象
        Pet.Address address = new Pet.Address();
        System.out.println("address = " + address);

        // 访问静态内部类中的方法
        address.printCountry(); // 实例级别
        Pet.Address.printCity(); // 静态级别，推荐
        // address.printCity(); // 静态级别 不推荐这种方式访问

    }
}
