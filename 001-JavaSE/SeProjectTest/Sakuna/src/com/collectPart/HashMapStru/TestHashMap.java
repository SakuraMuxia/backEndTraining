package com.collectPart.HashMapStru;

import java.util.HashMap;
import java.util.Iterator;

public class TestHashMap {
    public static void main(String[] args) {
        // 创建HashMap对象
        HashMap<String,String> hashMap = new HashMap<String,String>();
        // 添加元素
        hashMap.put("aqua", "阿夸色");
        hashMap.put("yousa", "当春乃发生");
        hashMap.put("Reine", "兔次元");
        hashMap.put("hanser", "油菜花");
        // 获取元素值
        String yousaValue = hashMap.get("yousa");
        System.out.println("yousaValue = " + yousaValue);

        // 遍历hashMap元素
        Iterator<String> iterator = hashMap.keySet().iterator();
        // 遍历迭代器对象
        while (iterator.hasNext()){
            String key = iterator.next();
            String value = hashMap.get(key);
            System.out.println(key + " == " + value);
        }
    }
}
