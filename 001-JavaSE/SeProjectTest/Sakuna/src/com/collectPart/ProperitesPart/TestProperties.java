package com.collectPart.ProperitesPart;

import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) {

        // 创建一个属性值为空的属性列表
        Properties properties = new Properties();
        // 向属性列表中添加元素
        Object cpu = properties.setProperty("CPU", "i9 9900K");
        // System.out.println("cpu = " + cpu); // cpu = null
        properties.setProperty("Mem","64GB");
        properties.setProperty("HardDrive","16TB");
        // 根据键获取值
        String mem = properties.getProperty("Mem");
        System.out.println("mem = " + mem); // mem = 64GB
        // list方法
        properties.list(System.out);

    }
}
