package com.singleLetonPart;

public class Test01 {
    public static void main(String[] args) {
        // 创建对象
        LazySingleLeton instance = LazySingleLeton.getInstance();
        System.out.println("instance = " + instance);

        HungrySingleLeton instance2 = HungrySingleLeton.getInstance();
        System.out.println("instance2 = " + instance2);
    }
}
