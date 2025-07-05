package com.abstractClass.Test1;

public class TestAnimal {
    public static void main(String[] args) {
        // 创建一个老虎对象
        Animal tiger = new Tiger();
        tiger.eat(); // 老虎吃肉

        // 创建一个狗狗对象 父类引用是Animal类
        Animal dog = new Dog();
        dog.eat(); // 狗狗吃骨头,调用的是Dog类中重写的方法
        // dog2.playWithMaster(); // 报错,Animal类中没有 playWithMaster() 方法

        // 创建一个狗狗对象 父类引用是Pet类
        Pet dog2 = new Dog();
        dog2.eat(); // 狗狗吃骨头,调用的是Dog类中重写的方法
        dog2.playWithMaster(); // 狗狗和主人玩飞盘,调用的是Dog类中重写的方法
    }
}
