package com.staticPart;

public class Eat {
    // 属性
    String name;
    String food;
    static int remain = 100;
    // 构造方法
    public Eat(){}
    // 构造方法
    public Eat(String name,String food){
        this.name = name;
        this.food = food;
    }
    // 实例方法
    public void info(){
        System.out.println(this.name + "吃了" + this.food + "现在剩余的事物数量为:"+ remain);
    }
    // 静态方法 drink
    public static void eatFood(){
        // 静态方法中使用静态属性
        Eat.remain -= 1;
    }
    // 测试类
    public static void main(String[] args) {
        Eat eater = new Eat("九月","泡面");
        // 实例调用静态方法：会出现警告，但是可以使用
        eater.eatFood();
        // 实例调用实例方法
        eater.info();
        // 实例调用静态属性：会出现警告，但是可以使用
        System.out.println("现在剩余的事物数量"+eater.remain);
    }
}
