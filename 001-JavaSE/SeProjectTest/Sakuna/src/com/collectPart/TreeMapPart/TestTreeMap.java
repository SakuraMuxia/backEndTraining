package com.collectPart.TreeMapPart;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestTreeMap {
    public static void main(String[] args) {
        // 创建Treemap对象 TreeMap后边的可省略，默认使用无参构造，使用类中重写 Comparable接口的方法
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        // 添加元素
        String sakuna = treeMap.put(18, "sakuna");
        // System.out.println("sakuna = " + sakuna); // sakuna = null
        treeMap.put(19,"yousa");
        treeMap.put(17,"小语");
        
        // 遍历集合
        Set<Map.Entry<Integer, String>> entries = treeMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }
}
