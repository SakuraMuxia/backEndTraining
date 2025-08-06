package com.ThreadPart;

public class TestMyThread2 {
    public static void main(String[] args) {
        // 创建Runnable实现类对象
        RunnableImpl runnable1 = new RunnableImpl();

        // 使用Thread的构造函数创建线程对象
        Thread thread1 = new Thread(runnable1,"线程A");
        Thread thread2 = new Thread(runnable1,"线程B");

        // 准备就绪
        thread1.start();
        thread2.start();
    }
}
