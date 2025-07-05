package com.abstractClass.Test1;

public class Dog extends Pet{
    // 重写父类中的抽象方法
    @Override
    public void playWithMaster() {
        System.out.println("狗狗和主人玩飞盘");
    }
    // 重写爷类中的抽象方法
    @Override
    public void eat() {
        System.out.println("狗狗吃骨头");
    }
}
