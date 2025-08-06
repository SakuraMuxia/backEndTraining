package com.ThreadPart;

public class TestMyThread {
    public static void main(String[] args) throws InterruptedException {
        // 创建 自定义线程对象
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        // 设置线程名称
        myThread1.setName("线程A");
        myThread2.setName("线程B");

        // 设置线程的优先级
        myThread1.setPriority(10);

        // 获取线程的优先级
        int priority1 = myThread1.getPriority();// 线程A 的优先级为 10
        int priority2 = myThread2.getPriority(); // 线程B 的优先级为 5
        // 打印优先级
        System.out.println(myThread1.getName() + " 的优先级为 " + priority1); // 线程A优先运行完毕
        System.out.println(myThread2.getName() + " 的优先级为 " + priority2);

        // 启动线程
        myThread1.start();
        myThread2.start();

    }
}
