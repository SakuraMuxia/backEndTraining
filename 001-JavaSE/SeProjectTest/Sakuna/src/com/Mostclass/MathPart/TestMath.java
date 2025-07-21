package com.Mostclass.MathPart;

public class TestMath {
    public static void main(String[] args) {
        System.out.println(Math.E); // 2.718281828459045
        System.out.println(Math.PI); // 3.141592653589793

        System.out.println(Math.abs(-123)); // 123
        System.out.println(Math.ceil(3.3)); // 4.0
        System.out.println(Math.floor(3.6)); // 3.0
        System.out.println(Math.round(3.5)); // 4
        System.out.println(Math.max(23, 33)); // 33
        System.out.println(Math.min(23, 33)); // 23

        double random = Math.random();
        System.out.println("random = " + random); // random = 0.03458259959718768
        System.out.println((int)(random * 100));  // 3

        System.out.println((int)(random * 12)); // 12以内随机数
    }
}
