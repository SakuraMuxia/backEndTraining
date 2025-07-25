package com.collectPart.TreeMapPart;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestVup {
    public static void main(String[] args) {
        // 创建三个对象
        VUP up1 = new VUP("yousa",19);
        VUP up2 = new VUP("Reine",20);
        VUP up3 = new VUP("Tori",21);
        // 创建TreeMap对象, 指定键值对泛型 为 VUP和String
        TreeMap<VUP,String> treeMap = new TreeMap<VUP,String>();
        // 添加元素
        treeMap.put(up1,"时光洪流");
        treeMap.put(up2,"哑谜");
        treeMap.put(up3,"桃子桃子桃");

        // 遍历Map集合
        Set<Map.Entry<VUP, String>> entries = treeMap.entrySet();
        for (Map.Entry<VUP, String> entry : entries) {
            // 直接打印对象,TreeMap类中重写了 Entry接口中的toString方法
            System.out.println(entry);
        }
    }
}
