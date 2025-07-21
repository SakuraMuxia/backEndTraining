package com.enumPart.Test01;

public class TestEnum01 {
    public static void main(String[] args) {
        // 枚举类不能创建对象，只能通过静态方法调用。
        Employee employee = Employee.getEmployeeById("002");
        System.out.println(employee); // Employee{id='002', job='总监', name='sakuna'}

        // 使用枚举类对象
        Employee cto = Employee.CTO;
        System.out.println("cto = " + cto); // cto = Employee{id='002', job='总监', name='sakuna'}

        // 枚举类对象 调用接口中实现的方法
        cto.doWork(); // sakuna在工作

    }
}
