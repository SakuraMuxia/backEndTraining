package com.enumPart.Test02;

/**
 *  枚举类使用enum修饰，所有的枚举类都默认继承自java.lang.Enum类。
 *  所以我们自定义的枚举类，不能继承其他类，但是可以实现接口。
 *  枚举类不能new对象。
 *  枚举类中默认书写的内容全部为：全局静态常量 public static final 修饰的值。
 */

// 定义枚举类
public enum Gender {
    // 全局静态常量
    MALE,FEMALE
}
