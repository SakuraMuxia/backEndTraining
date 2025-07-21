package com.Mostclass.Random;

import java.util.Random;

public class TestRandom {
    public static void main(String[] args) {
        Random random = new Random(); // 创建随机数对象

        System.out.println(random.nextBoolean()); // 生成一个随机布尔值
        System.out.println(random.nextInt()); // 生成一个随机 int值
        System.out.println(random.nextInt(100)); // 生成一个随机 范围内的 int值
        System.out.println(random.nextFloat()); // 生成一个随机 浮点值
        System.out.println(random.nextDouble()); // 生成一个随机 double值
    }
}
