package com.collectPart.SetPart;

import java.util.HashSet;
import java.util.Iterator;

public class TestSetPart {
    public static void main(String[] args) {
        // 创建HashSet列表 指定键的泛型为String
        HashSet<String> hashSet = new HashSet<String>();
        // 向列表中添加元素
        boolean reine = hashSet.add("Reine");
        // 获取列表中数量
        int size = hashSet.size();
        System.out.println("size = " + size);

        // 遍历集合
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            String item = iterator.next();
            System.out.println("item = " + item);

        }
        // 通过增强for遍历
        for (String s : hashSet) {
            System.out.println("s = " + s);
        }

    }
}
