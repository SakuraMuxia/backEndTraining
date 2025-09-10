package com.ReflectPart.classLoader;

import sun.net.spi.nameservice.dns.DNSNameService;

public class TestClassLoader {
    public static void main(String[] args) {
        // BootStrap ClassLoader 加载器的使用
        Object obj = new Object();
        // 获取对象的类加载器
        ClassLoader classLoader = obj.getClass().getClassLoader();
        System.out.println("classLoader = " + classLoader); // null

        // 拓展包加载
        ClassLoader classLoader1 = DNSNameService.class.getClassLoader();
        System.out.println("classLoader1 = " + classLoader1); // sun.misc.Launcher$ExtClassLoader@2503dbd3

        // 自定义类
        ClassLoader classLoader2 = TestClassLoader.class.getClassLoader();
        System.out.println("classLoader2 = " + classLoader2); // sun.misc.Launcher$AppClassLoader@18b4aac2

        // 获取父类加载器
        ClassLoader parent = classLoader2.getParent();
        System.out.println("parent = " + parent); // sun.misc.Launcher$ExtClassLoader@2503dbd3
    }
}
