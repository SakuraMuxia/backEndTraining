package com.finalFiled;

/**
 * 被final修饰的属性称之为常量 表示其值或者地址不能被改变
 * 这样的数据通常也没有必要存在多份 所以实际开发中经常会用static final修饰不允许被改变的数据
 * 因为只有一份 且 数据无法改变 所以通常也会再加上public修饰 称之为：全局 静态 常量
 *
 * 静态常量：通常在定义的时候赋值 或者 在静态代码块中赋值 这两种方式同样是为了保证在使用常量之前是有值的
 */

public class TestStaticFinalField {
    // 定义 全局静态常量
    public static final double PI = 3.14;
    // 定义 静态常量
    static final String COUNTRY_NAME;

    // 在代码块中 给静态常量赋值
    static{
        COUNTRY_NAME =   "中华人民共和国";
    }
    // 定义 构造方法
    public TestStaticFinalField(){

    }
}
