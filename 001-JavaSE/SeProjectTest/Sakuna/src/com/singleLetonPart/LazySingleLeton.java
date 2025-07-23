package com.singleLetonPart;

public class LazySingleLeton {
    // 定义一个 私有静态 实例对象为空,先不new对象，懒汉单例
    private static LazySingleLeton instance = null;

    // 构造方法私有，才能保证内存中只有一份
    private LazySingleLeton(){}

    // 定义静态方法
    public static LazySingleLeton getInstance(){
        if (instance == null){ // 当instance为空时
            instance = new LazySingleLeton(); // 创建对象
        }
        return instance;
    }
}
