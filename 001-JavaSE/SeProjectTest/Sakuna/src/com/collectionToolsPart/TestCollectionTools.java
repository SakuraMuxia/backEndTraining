package com.collectionToolsPart;

import java.util.ArrayList;
import java.util.Collections;

public class TestCollectionTools {
    public static void main(String[] args) {
        // 创建ArrayList集合对象
        ArrayList<Singer> arrayList = new ArrayList<Singer>();
        // 创建 Singer对象
        Singer s1 = new Singer("Sakuna",26);
        Singer s2 = new Singer("冰糖IO",27);
        Singer s3 = new Singer("yousa",26);
        Singer s4 = new Singer("Akie",25);
        // 往集合中添加元素
        arrayList.add(s1);
        arrayList.add(s2);
        arrayList.add(s3);
        arrayList.add(s4);
        // 使用集合工具类,未使用工具类排序，默认是元素的插入顺序。
        // 使用工具类 sort方法排序，默认是升序
        Collections.sort(arrayList);

        // 遍历集合
        for (Singer singer : arrayList) {
            System.out.println(singer);
        }
    }
}
