package com.moreThread;

import java.util.concurrent.ArrayBlockingQueue;

// 生产线程，用于生产电脑
public class Producer extends Thread{

    // 定义属性 数组阻塞队列 对象
    private ArrayBlockingQueue<Computer> queue;

    public Producer(ArrayBlockingQueue<Computer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1;i<=20;i++){
            // 创建电脑产品对象
            Computer computer = new Computer();
            // 生产电脑
            // 如果 i 为偶数，生产联想电脑，否则生产华硕电脑
            if (i % 2 == 0){
                computer.setHost(i + "号" + "联想电脑主机");
                computer.setMonitor(i + "号" + "联想电脑显示器");
                System.out.println("厂家 生产了第"+ i +"号联想电脑");
                // 把生产的对象添加到队列
                queue.add(computer);
            }else{
                computer.setHost(i + "号" + "华硕电脑主机");
                computer.setMonitor(i + "号" + "华硕电脑显示器");
                System.out.println("厂家 生产了第"+ i +"号华硕电脑");
                // 把生产的对象添加到队列
                queue.add(computer);
            }
        }
    }
}
