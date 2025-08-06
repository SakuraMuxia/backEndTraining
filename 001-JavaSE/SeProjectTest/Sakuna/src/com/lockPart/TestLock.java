package com.lockPart;

public class TestLock {
    public static void main(String[] args) {
        // 创建Runnable实现类对象
        BuyTicket runnable = new BuyTicket();
        // 创建线程，并设置线程名称
        Thread th1 = new Thread(runnable,"Aqua");
        Thread th2 = new Thread(runnable,"Kanoco");
        Thread th3 = new Thread(runnable,"Reine");
        // 开启线程
        th1.start();
        th2.start();
        th3.start();
    }
}
