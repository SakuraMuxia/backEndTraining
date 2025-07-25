package com.collectPart.LinkedHashMapPart;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class TestLinkedHashMap {
    public static void main(String[] args) {
        // 创建LinkedHashMap对象, 设置泛型
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<String,String>();

        // 向Map集合中添加元素
        linkedHashMap.put("Sakuna", "湛蓝依旧");
        linkedHashMap.put("yousa","大喜");
        linkedHashMap.put("Reine","窃窃");

        // 遍历元素，没有下标只能通过迭代器方式
        Iterator<String> iterator = linkedHashMap.keySet().iterator();
        // 遍历
        while(iterator.hasNext()){
            String key = iterator.next();
            String value = linkedHashMap.get(key);
            System.out.println(key + " == " + value);
        }

        // 增强for
        Set<Map.Entry<String, String>> entries = linkedHashMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " == " + value);
        }
    }
}
