package com.collectionToolsPart;

import java.util.ArrayList;
import java.util.Collections;

public class TestCollections {
    public static void main(String[] args) {
        // 利用Integer类中的重写的自然排序
        ArrayList<Integer> arrayList = new ArrayList<>();
        // 添加元素
        arrayList.add(15);
        arrayList.add(20);
        arrayList.add(18);
        arrayList.add(15);
        // 使用二叉搜索算法搜索指定对象的指定列表
        int i = Collections.binarySearch(arrayList, 17);
        System.out.println("i = " + i);

        // 遍历元素 默认顺序是 元素插入顺序
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
    }
}
