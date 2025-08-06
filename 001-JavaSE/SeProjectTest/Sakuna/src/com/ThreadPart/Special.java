package com.ThreadPart;

public class Special extends Thread{
    @Override
    public void run() {
        // 循环10次，作为10次号
        for (int i = 0;i < 10;i++){
            // 看病时间
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 提示信息
            System.out.println(Thread.currentThread().getName() + "第" + i + "号在看病");
        }
        System.out.println(Thread.currentThread().getName() + "看病完毕");
    }
    // main线程作为普通号
    public static void main(String[] args) throws InterruptedException {
        // 创建对象
        Special special = new Special();
        // 设置线程名称
        special.setName("*****特需号*****");
        // 设置线程优先级
        special.setPriority(MAX_PRIORITY);
        // 开启线程
        special.start();
        // 获取当前线程对象
        Thread mainThread = Thread.currentThread();
        // 设置当前线程对象的线程名称
        mainThread.setName("普通号");
        // 遍历普通号过程
        for(int i = 1;i <= 50;i++){
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + "第" + i + "号在看病");

            if(i == 10){
                // 当遍历到第10号看病时，特殊号加队
                special.join();
            }
        }
        System.out.println(Thread.currentThread().getName() + "看病完毕");
    }
}
