package com.ThreadPart;

public class TestThread01 {
    public static void main(String[] args) {
        // 获取当前Thread类对象(线程对象)
        Thread thread = Thread.currentThread();
        // 打印线程名称
        System.out.println("当前线程对象 " + thread); // Thread[main,5,main]
        // 获取当前线程对象名称
        String name = thread.getName();
        System.out.println("当前线程名称 " + name); // main
        // 设置当前线程名称
        thread.setName("主线程");

    }
}
