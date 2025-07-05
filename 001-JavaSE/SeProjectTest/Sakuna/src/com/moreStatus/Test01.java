package com.moreStatus;

public class Test01 {
    public static void main(String[] args) {
        // 创建宠物类
        Pet pet = new Dog("十一月",98,39,"乌萨齐"); // 向上转型
        Dog dog = new Dog("艾特",97,56,"阿拉斯加");
        pet.cure(); // 调用的是子类中重写的实例方法
        pet.eat(); // 调用的是父类中static方法,通过父类引用指向子类对象的调用。
        dog.eat(); // 调用的是子类中static方法,通过子类引用指向子类对象的调用。父类的static方法隐藏了
    }
}
