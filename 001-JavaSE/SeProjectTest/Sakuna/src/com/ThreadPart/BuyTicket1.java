package com.ThreadPart;

// 未使用 sync线程同步关键字
public class BuyTicket1 implements Runnable{
    // 定义属性
    int ticketCount = 10;

    @Override
    public void run() {
        while (ticketCount > 0){
            // 线程休眠-保证每个线程都有机会抢到票
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // ticketCount--;
            ticketCount--;
            // 提示信息
            System.out.println(Thread.currentThread().getName() + "抢到了第" + (10 - ticketCount) + "张票，还剩余" + ticketCount + "张票");
        }
        System.out.println("票卖完了");
    }

    // 测试类
    public static void main(String[] args) {
        // 创建Runnable对象
        BuyTicket1 runnable = new BuyTicket1();
        // 创建线程对象
        Thread th1 = new Thread(runnable, "赵四");
        Thread th2 = new Thread(runnable, "广坤");
        Thread th3 = new Thread(runnable, "大拿");

        th1.start();
        th2.start();
        th3.start();
    }
}
