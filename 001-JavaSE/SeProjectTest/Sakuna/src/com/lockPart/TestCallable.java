package com.lockPart;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// 设置泛型 为 Integer类型
public class TestCallable implements Callable<Integer> {

    // 声明返回值为 Integer类型
    @Override
    public Integer call() throws Exception {
        System.out.println("当前线程名称" + Thread.currentThread().getName());
        return 114514;
    }

    // 测试方法
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建Callable实现类对象，定义任务
        TestCallable testCallable = new TestCallable();
        // 创建FutureTask实现类对象，使用Callable接口实现类作为参数 构造实例，定义任务
        FutureTask<Integer> task = new FutureTask<Integer>(testCallable);
        // 创建线程对象 传入FutureTask 相当于传入Runnable实现类，定义线程
        Thread thread = new Thread(task, "线程A");
        // 线程就绪
        thread.start();
        // 获得任务的返回值
        Integer integer = task.get();
        System.out.println(integer); // 返回任务计算后的结果 114514
    }
}
