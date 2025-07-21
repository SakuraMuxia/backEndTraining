package com.baoZhuangPart.Test01;

/**
 * parseXXX ： 每个包装类都提供有parseXXX方法 用于将字符串转化为基本数据类型 此方法为静态方法
 */

public class TestParseXXX {
    public static void main(String[] args) {
        byte b = Byte.parseByte("123");
        System.out.println("b = " + b);

        short i = Short.parseShort("123");
        System.out.println("i = " + i);

        int i1 = Integer.parseInt("123");
        System.out.println("i1 = " + i1);

        long l = Long.parseLong("1234");
        System.out.println("l = " + l);


        float v = Float.parseFloat("3.5F");
        System.out.println("v = " + v);

        double v1 = Double.parseDouble("123");
        System.out.println("v1 = " + v1);

        // 转换规则和Boolean包装类使用字符串构造实例相同
        boolean abc = Boolean.parseBoolean("abc");
        System.out.println("abc = " + abc);
    }
}
