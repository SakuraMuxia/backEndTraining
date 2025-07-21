package com.baoZhuangPart.Test01;
/**
 *
 *  基本数据类型====》包装对象
 *  每个包装类都提供有valueOf方法 用于将基本数据类型转换为包装类对象 此方法为静态方法
 *  static valueOf()
 *
 */
public class TestValueOf {
    public static void main(String[] args) {
        // 基本数据类型 11 转为包装类对象
        Byte aByte = Byte.valueOf((byte) 11);
        System.out.println("aByte = " + aByte);
        System.out.println("---------------------------------");
        Short aShort = Short.valueOf((short) 11);
        System.out.println("aShort = " + aShort);
        System.out.println("---------------------------------");
        Integer integer = Integer.valueOf(123);
        System.out.println("integer = " + integer);
        System.out.println("---------------------------------");
        Long aLong = Long.valueOf(12344);
        System.out.println("aLong = " + aLong);
        System.out.println("---------------------------------");
        Boolean aBoolean = Boolean.valueOf(true);
        System.out.println("aBoolean = " + aBoolean);
        System.out.println("---------------------------------");
        Character character = Character.valueOf('a');
        System.out.println("character = " + character);

    }
}
