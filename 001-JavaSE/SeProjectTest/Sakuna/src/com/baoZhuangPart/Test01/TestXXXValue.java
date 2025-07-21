package com.baoZhuangPart.Test01;

/**
 *
 *  包装对象 -> 基本数据类型
 *  每个包装类都提供有xxxValue()方法，用于将包装类对象，转换为基本数据类型，此方法为实例方法
 */

public class TestXXXValue {
    public static void main(String[] args) {
        // 包装类对象
        Byte b1 = new Byte("123");
        // 使用 byteValue() 转为基本数据类型
        byte b = b1.byteValue();
        System.out.println("b = " + b);
        Short s1 = new Short("123");
        short i = s1.shortValue();
        System.out.println("i = " + i);

        System.out.println("-------------------------------");

        Integer i1 = new Integer("123");
        int i2 = i1.intValue();
        System.out.println("i2 = " + i2);

        System.out.println("-------------------------------");


        Long l1 = new Long("11234");
        long l = l1.longValue();
        System.out.println("l = " + l);

        System.out.println("-------------------------------");

        Boolean bl1 = new Boolean(true);
        boolean b2 = bl1.booleanValue();
        System.out.println("b2 = " + b2);

        System.out.println("-------------------------------");

        Character ch1 = new Character('a');
        char c = ch1.charValue();
        System.out.println("c = " + c);
    }
}
