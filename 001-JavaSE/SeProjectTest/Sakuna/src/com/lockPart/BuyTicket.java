package com.lockPart;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多人抢票 三个人 抢10张票
 * 有一个线程买票 前边的线程购买完毕 后边的线程才能继续购买
 */
public class BuyTicket implements Runnable{

    // 定义票数
    int ticketCount = 10;
    // 创建锁对象 独占锁对象
    Lock lock = new ReentrantLock();

    // 线程执行的区域
    @Override
    public void run() {
        // 循环遍历
        while (true){
            try {
                // 每个线程进来先休眠
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 然后把后续的代码上锁,只允许同时只有一个线程执行后续代码
                lock.lock();
                if (ticketCount == 0) {
                    break;
                }
                ticketCount--;
                System.out.println(Thread.currentThread().getName() + "抢到了，第" + (10 - ticketCount) +"张票,还剩余" + ticketCount + "张票");
            }finally {
                // 解锁
                lock.unlock();
            }
        }
        System.out.println("票卖完了");
    }
}
