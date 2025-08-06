package com.ThreadPart;

public class MyThread extends Thread{
    @Override
    public void run() { // 运行
        // 自定义线程执行的代码
        // 遍历当前线程的名称
        for (int i = 0;i<=20;i++){
            try {
                // 线程睡眠，阻塞状态
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 当i取值为10  则礼让 但不保证一定会礼让成功
            // if (i == 10){
            //     System.out.println(Thread.currentThread().getName() + "线程礼让了");
            //     Thread.yield(); // 线程礼让
            // }
            System.out.println(Thread.currentThread().getName() + "执行, 第" + i + "次");
        }
        // 线程执行完毕
        System.out.println(Thread.currentThread().getName() + "线程执行完毕");
        // 线程挂了
    }
}
