package com.finalFiled;

public class TestFinalFiled {
    // 定义 圆周率 PI
    final double PI = 3.14;
    // 定义 座位数 基本数据类型
    final int SEAT_COUNT;
    // 定义 引用数据类型
    final char [] SIGNS = new char[3];
    double radius;

    // 在构造方法中赋值
    public TestFinalFiled() {
        SEAT_COUNT = 60;
    }
    // 在构造方法中赋值
    public TestFinalFiled(double radius) {
        SEAT_COUNT = 70;
        this.radius = radius;
    }
    // 测试类
    public static void main(String[] args) {
        // 创建实例
        TestFinalFiled testFinalFiled = new TestFinalFiled();
        // testFinalFiled.PI = 3.24; // 报错：final修饰的变量，仅允许被赋值一次
        testFinalFiled.radius = 10; // 普通实例方法可以被赋值多次
        System.out.println("圆的面积为" + testFinalFiled.radius * testFinalFiled.radius * testFinalFiled.PI);

        // 引用数据类型地址不能改变
        // testFinalFiled.SIGNS = new char[2]; // 报错：final修饰的变量，仅允许被赋值一次，数据类型是引用数据类型，地址不能改变。
        // 引用数据类型内容只能改变一次
        testFinalFiled.SIGNS[0] = 'a';
        testFinalFiled.SIGNS[1] = 'b';
        testFinalFiled.SIGNS[2] = 'c';
    }
}
