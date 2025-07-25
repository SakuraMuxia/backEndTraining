package com.collectPart.TreeMapPart;

import java.util.Comparator;

// 实现 Comparator 接口，同时设置泛型为 Singer类型
public class ComparaSinger implements Comparator<Singer> {
    @Override
    public int compare(Singer o1, Singer o2) {
        // o1大于o2 返回正数  o1小于o2 返回负数  o1==o2 返回0
        return  o1.getAge() > o2.getAge() ? 1 :  (o1.getAge() < o2.getAge() ? -1  : 0) ;
    }
}
