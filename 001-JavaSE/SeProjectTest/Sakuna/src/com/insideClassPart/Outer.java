package com.insideClassPart;

public class Outer {
    private String field1;
    private int field2;

    public void m1(){
        // 访问 实例属性
        this.field1 = "aqua";
        this.field2 = 18;
        System.out.println(field1);
        System.out.println(field2);

        // 定义局部变量
        int a = 100;
        a += 1;
        System.out.println("a = " + a);

        // 定义内部类

    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        // 调用 外部类中的 m1 方法
        outer.m1();
    }
}
