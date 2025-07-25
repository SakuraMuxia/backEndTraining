package com.collectPart.SetPart;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class TestLinkedHashSet {
    public static void main(String[] args) {
        // 创建对象
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        // 添加元素
        linkedHashSet.add("Reine");
        // 遍历集合
        Iterator<String> iterator = linkedHashSet.iterator();
        while (iterator.hasNext()){
            String item = iterator.next();
            System.out.println("item = " + item); // item = Reine
        }
    }
}
