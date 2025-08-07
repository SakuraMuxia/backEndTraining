package com.lockPart;

import java.util.concurrent.*;

public class TestExcutors {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建带缓存的线程池
        ExecutorService es1 = Executors.newCachedThreadPool();
        // 创建线程 指定线程数为 10
        ExecutorService es2 = Executors.newFixedThreadPool(10);
        // 创建线程 创建可以定时任务的线程
        ScheduledExecutorService es3 = Executors.newScheduledThreadPool(5);
        // 创建线程池，单线程
        ExecutorService es4 = Executors.newSingleThreadExecutor();

        // 定义并提交任务，通过Runnable实现类，执行线程
        es1.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程池1：" + Thread.currentThread().getName()); // 线程池1：pool-1-thread-1
            }
        });
        // 提交任务，并新建线程1执行
        es2.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程池2：" + Thread.currentThread().getName()); // 线程池2：pool-2-thread-1
            }
        });
        // 提交任务，并新建线程2执行
        es2.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程池2：" + Thread.currentThread().getName()); // 线程池2：pool-2-thread-2
            }
        });
        // 提交任务，并设置定时任务执行，新建线程执行
        es3.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程池3：" + Thread.currentThread().getName()); // 延迟20秒后执行，线程池3：pool-3-thread-1
            }
        },20, TimeUnit.SECONDS);
        // 提交任务，创建线程
        es4.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程池4：" + Thread.currentThread().getName()); // pool-4-thread-1 同一个线程执行
            }
        });
        Future<Integer> futureRes = es4.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("线程池4：" + Thread.currentThread().getName()); // pool-4-thread-1
                return 100;
            }
        });
        // 获取任务执行的结果
        Integer integer = futureRes.get();
        System.out.println("integer"+integer); // integer100
        // 提交任务，创建线程
        es4.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程池4：" + Thread.currentThread().getName()); // pool-4-thread-1 同一个线程执行
            }
        });
        // 关闭线程池，有序关闭线程
        es4.shutdown();
    }
}
