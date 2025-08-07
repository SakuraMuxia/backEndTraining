package com.lockPart;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 不使用synchronized关键字，不同的线程获取到的对象不是同一个
// 使用synchronized关键字，不同的线程获取到的对象是同一个
public class TestSingleInstance {
    public static void main(String[] args) throws InterruptedException {
        // 创建线程池
        ExecutorService es1 = Executors.newFixedThreadPool(5);
        // 定义任务，创建线程1，提交执行
        es1.submit(new Runnable() {
            @Override
            public void run() {
                // 创建实例
                try {
                    SingleInstance single1 = SingleInstance.getSingleMode();
                    // 线程池1pool-1-thread-1获取单例对象com.lockPart.SingleInstance@3168743e
                    System.out.println("线程池1" + Thread.currentThread().getName() + "获取单例对象" + single1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 定义任务，创建线程1，提交执行
        es1.submit(new Runnable() {
            @Override
            public void run() {
                // 创建实例
                try {
                    SingleInstance single1 = SingleInstance.getSingleMode();
                    // 线程池1pool-1-thread-2获取单例对象com.lockPart.SingleInstance@51e03dd8
                    System.out.println("线程池1" + Thread.currentThread().getName() + "获取单例对象" + single1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 定义任务，创建线程1，提交执行
        es1.submit(new Runnable() {
            @Override
            public void run() {
                // 创建实例
                try {
                    SingleInstance single1 = SingleInstance.getSingleMode();
                    // 线程池1pool-1-thread-2获取单例对象com.lockPart.SingleInstance@51e03dd8
                    System.out.println("线程池1" + Thread.currentThread().getName() + "获取单例对象" + single1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 关闭线程池
        es1.shutdown();

    }
}
