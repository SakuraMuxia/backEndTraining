package com.collectPart.LinkedListPart;

import java.util.Iterator;
import java.util.LinkedList;

public class Test01 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        boolean res = linkedList.add("sakuna");
        linkedList.add(1,"yousa");
        linkedList.add(2,"Hikari");

        linkedList.addFirst("charl");
        linkedList.addLast("Reine");

        // 删除元素
        Object rmItem = linkedList.remove(2);
        System.out.println("rmItem = " + rmItem); // rmItem = yousa
        // 修改元素
        Object liuEr = linkedList.set(1, "liuEr");

        // 删除第一个元素
        Object rmFirstItem = linkedList.removeFirst();
        System.out.println("rmFirstItem = " + rmFirstItem); // rmFirstItem = charl
        // 删除最后一个元素
        Object rmLastItem = linkedList.removeLast();
        System.out.println("rmLastItem = " + rmLastItem); // rmLastItem = Reine

        // 迭代器遍历
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()){
            Object item = iterator.next();
            System.out.println("item = " + item);
        }
    }
}
