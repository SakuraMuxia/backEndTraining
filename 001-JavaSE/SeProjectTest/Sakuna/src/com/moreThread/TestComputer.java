package com.moreThread;

import java.util.concurrent.ArrayBlockingQueue;

public class TestComputer {
    public static void main(String[] args) {
        // 创建 阻塞队列对象,并设置队列的长度为20
        ArrayBlockingQueue<Computer> queue = new ArrayBlockingQueue<>(20);

        // 创建线程对象,参数是有参构造,同时参数是同一个队列
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        // 开始线程
        producer.start();
        consumer.start();

    }
}
