package com.lockPart;

public class SingleInstance {
    // 定义一个 私有静态 实例对象为空,先不new对象，懒汉单例
    private static SingleInstance instance = null;

    // 构造方法私有，才能保证内存中只有一份
    private SingleInstance(){}

    // 静态方法，获取一个实例
    public static synchronized SingleInstance getSingleMode() throws InterruptedException {
        if (instance == null){
            // 线程进来先休眠
            Thread.sleep(200);

            // 创建一个实例
            instance = new SingleInstance();
        }
        // 把这个实例返回
        return instance;
    }
}
