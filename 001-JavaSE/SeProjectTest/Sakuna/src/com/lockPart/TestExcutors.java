package com.lockPart;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExcutors {
    public static void main(String[] args) {
        // 创建带缓存的线程池
        ExecutorService es1 = Executors.newCachedThreadPool();

        // 定义并提交任务，通过Runnable实现类
        es1.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("es1 = " + es1);
            }
        });

    }
}
