package com.collectPart.SetPart;

import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {
        // 无参构造
        TreeSet<String> set = new TreeSet<String>();
        // 添加元素
        set.add("sakuna");
        set.add("yousa");
        set.add("xusong");
        // 查找第一个元素
        String first = set.first();
        System.out.println("first = " + first); // first = sakuna
    }
}
