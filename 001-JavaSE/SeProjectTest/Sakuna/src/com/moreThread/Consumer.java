package com.moreThread;

import java.util.concurrent.ArrayBlockingQueue;

// 消费者线程 负责消费电脑
public class Consumer extends Thread{
    // 设置属性为 队列
    private ArrayBlockingQueue queue;

    public Consumer(ArrayBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i =1 ; i <= 20 ;i++){
            Computer computer = new Computer();
            // 消费电脑
            try {
                // 取出电脑属性
                Object obj = queue.take();
                System.out.println("消费者消费了" + (Computer)obj);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
