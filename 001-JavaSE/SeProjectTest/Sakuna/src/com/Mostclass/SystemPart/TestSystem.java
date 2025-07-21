package com.Mostclass.SystemPart;

import java.util.Properties;

public class TestSystem {
    public static void main(String[] args) {
        // currentTimeMillis()
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis = " + currentTimeMillis);

        long l = System.nanoTime();
        System.out.println("l = " + l);

        // 获取当前系统的所有的属性
        Properties properties = System.getProperties(); // 得到一个对象，键值对的形式
        // 使用 Properties类中 实例的方法 list(), list()方法中参数 是一个PrintStream类的对象，
        // System.out 就是一个 PrintStream 类型的对象，把out传入
        properties.list(System.out); // 打印到控制台

        // 获取键值对信息
        String javaVersion = System.getProperty("java.version");
        System.out.println("javaVersion = " + javaVersion);

        // 创建一个Student对象
        Student stu = new Student();
        stu = null; // 引用指向为空
        // 垃圾回收器检测到 有一个Student对象可以被回收，会自动调用该对象的 finalize方法
        // 运行垃圾回收器,回收可以被回收的对象
        System.gc();

        // 退出虚拟机,后边的代码不会再执行
        System.exit(1);
        
    }
}
