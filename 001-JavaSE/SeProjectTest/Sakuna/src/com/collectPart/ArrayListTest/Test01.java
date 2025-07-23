package com.collectPart.ArrayListTest;

import java.util.ArrayList;
import java.util.Iterator;

public class Test01 {
    public static void main(String[] args) {
        // 创建ArrayList对象,同时设置泛型
        ArrayList<String> arrlist = new ArrayList<String>();

        // add 方法 实例级别
        boolean res = arrlist.add("sakuna");
        // 在指定位置插入元素
        // arrlist.add(0,44.5); // 报错，因为泛型为 String，集合内的元素对象类型必须是 String
        arrlist.add("春绯小语");

        // 迭代器遍历
        // 创建迭代器对象
        Iterator<String> iterator = arrlist.iterator();

        // 使用迭代器类中的实例方法 iterator.hasNext() 判断当前迭代器对象中是否还有元素
        // while (iterator.hasNext()){
        //     System.out.println(iterator.next());
        // }

        // 增强for循环
        for (String str : arrlist) {
            System.out.println("str = " + str);
        }



    }

}
