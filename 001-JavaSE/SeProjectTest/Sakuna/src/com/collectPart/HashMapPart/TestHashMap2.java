package com.collectPart.HashMapPart;

import java.util.*;

public class TestHashMap2 {
    public static void main(String[] args) {
        // 创建HashMap对象
        HashMap<String,String> hashMap = new HashMap<String,String>();
        // 添加元素
        hashMap.put("aqua", "阿夸色");
        hashMap.put("yousa", "当春乃发生");
        hashMap.put("Reine", "兔次元");
        hashMap.put("hanser", "油菜花");
        // 方式1：获取所有的键 根据键获取值
        // Set<String> keyList = hashMap.keySet();
        // // set集合没有下标，不能使用普通for循环，需要使用迭代器
        // for (String item : keyList) {
        //     // 根据key获取value
        //     String value = hashMap.get(item);
        //     // 打印 key value
        //     System.out.println(item + " == " + value);
        // }
        
        // 方式2：遍历所有的值
        // 获取所有值
        // Collection<String> valList = hashMap.values();
        // // 遍历所有值
        // for (String val : valList) {
        //     System.out.println("val = " + val);
        // }

        // 方式3：获取所有的键值对的组合
        // 获取所有的键值对列表,每一个Node(键值对)就是 entry
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        // 遍历 entries对象 ，entry就是每个键值对元素
        for (Map.Entry<String, String> entry : entries) {
            // 获取键 entry.getKey() 使用的是 Entry接口中的方法
            String key = entry.getKey();
            // 获取值 entry.getValue() 使用的是 Entry接口中的方法
            String value = entry.getValue();
            System.out.println(key + " == " + value);

        }

        // 方式4：获取所有的键的迭代器
        // 获取 所有键的 迭代器对象
        Iterator<String> iterator = hashMap.keySet().iterator();
        // 遍历迭代器对象
        while (iterator.hasNext()){
            String key = iterator.next();
            String value = hashMap.get(key);
            System.out.println(key + " == " + value);
        }

        // 方式6 ：
        // 获取所有的键值对组合的迭代器
        Iterator<Map.Entry<String, String>> iterator1 = hashMap.entrySet().iterator();
        // 遍历迭代器对象
        while (iterator1.hasNext()){
            // 获取键值对
            Map.Entry<String, String> entry = iterator1.next();
            // hashMap类中的Node类重写了 toString方法
            // static class Node<K,V> implements Map.Entry<K,V> {
            System.out.println(entry);
        }
    }
}
