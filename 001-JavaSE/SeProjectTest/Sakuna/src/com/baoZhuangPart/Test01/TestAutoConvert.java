package com.baoZhuangPart.Test01;

public class TestAutoConvert {
    public static void main(String[] args) {
        Integer i1 = 100; // 底层相当于调用了 valueOf(100);基本数据类型转为包装类对象
        int number = i1; // 底层相当于调用了 intValue() 包装类对象转为基本数据类型
        System.out.println("-----------------------------------");
        Byte a = new Byte("123"); // 装箱
        byte b = a.byteValue(); // 拆箱
        byte c = 1;
        System.out.println(b + c);
        System.out.println("-----------------------------------");
        Short s1 = new Short("123");
        short s2 = 123;
        System.out.println(s1 + s2);
    }
}
