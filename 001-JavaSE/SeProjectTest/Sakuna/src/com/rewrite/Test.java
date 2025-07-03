package com.rewrite;

public class Test {
    public static void main(String[] args) {
        Person per1 = new Person("sakuna","410883200205067898");
        Person per2 = new Person("saba","410883200205067899");
        // 使用 Person类中重写的 equals 方法
        boolean result = per1.equals(per2);
        System.out.println("idCard对比的结果为 "+result);
        // 使用 Person类中重写的 hashCode 方法
        System.out.println("p1的哈希值为 "+per1.hashCode());
        System.out.println("p2的哈希值为 "+per1.hashCode());
    }
}
