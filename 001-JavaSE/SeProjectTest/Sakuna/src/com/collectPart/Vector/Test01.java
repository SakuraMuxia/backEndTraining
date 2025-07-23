package com.collectPart.Vector;

import java.util.Iterator;
import java.util.Vector;

public class Test01 {
    public static void main(String[] args) {
        Vector vector = new Vector();
        boolean res1 = vector.add("sakuna is kawaii");
        vector.add(1,"yousa");
        boolean res2 = vector.remove("yousa");
        // 普通for循环遍历
        for (int i = 0; i < vector.size(); i++) {
            Object item = vector.get(i);
            System.out.println("item = " + item);
        }
        // 迭代器遍历
        Iterator iterator = vector.iterator();
        while (iterator.hasNext()){
            Object item = iterator.next();
            System.out.println("item = " + item);
        }
        // 增强for遍历
        for (Object item : vector) {
            System.out.println("item = " + item);
        }
    }
}
