package com.collectPart.TreeMapPart;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestSinger {
    public static void main(String[] args) {

        // 创建singer对象
        Singer singer1 = new Singer("Reine",23);
        Singer singer2 = new Singer("许嵩",39);
        Singer singer3 = new Singer("李荣浩",40);

        // 创建TreeMap集合,通过有参构造，参数是 ComparaSinger 类的对象
        TreeMap<Singer,String> treeMap = new TreeMap<>(new ComparaSinger());

        // 向集合中添加元素
        treeMap.put(singer1,"窃窃");
        treeMap.put(singer2,"有何不可");
        treeMap.put(singer3,"年少有为");

        // 遍历
        Set<Map.Entry<Singer, String>> entries = treeMap.entrySet();
        for (Map.Entry<Singer, String> entry : entries) {
            System.out.println(entry);
        }
    }
}
