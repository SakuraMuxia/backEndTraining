package com.baoZhuangPart.Test01;

/**
 * toString():以字符串形式返回包装对象表示的基本类型数据（基本类型->字符串）
 */

public class TestToString {
    public static void main(String[] args) {
        // 将基本数据类型转为字符串
        String s1 = Byte.toString((byte) 123);
        System.out.println("s1 = " + s1);
        String s2 = Short.toString((short) 1234);
        System.out.println("s2 = " + s2);

        String s3 = Integer.toString(123);
        System.out.println("s3 = " + s3);

        String s4 = Long.toString(123);
        System.out.println("s4 = " + s4);

        String s5 = Boolean.toString(true);
        System.out.println("s5 = " + s5);

        String s6 = Float.toString(3.5F);
        System.out.println("s6 = " + s6);

        String s7 = Double.toString(2.2);
        System.out.println("s7 = " + s7);

        String s8 = Character.toString('A');
        System.out.println("s8 = " + s8);
    }
}
