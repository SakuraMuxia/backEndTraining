package com.singleLetonPart;

public class HungrySingleLeton {
    // 上来就创建对象,饿汉单例
    private static HungrySingleLeton instance = new HungrySingleLeton();

    private HungrySingleLeton(){};

    public static HungrySingleLeton getInstance(){
        return instance;
    }
}
