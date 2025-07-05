package com.moreStatus;

public class Dog extends Pet{
    private String strain;

    public String getStrain() {
        return strain;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }

    public Dog(String name, int health, int love, String strain) {
        super(name, health, love);
        this.strain = strain;
    }

    public Dog() {}

    // 重写父类看病方法

    @Override
    public void cure() {
        System.out.println("狗狗看病，吃药，吃骨头，健康值恢复");
        this.setHealth(100);
    }
    // 狗狗玩飞盘方法
    public void playFlyDisc(){
        System.out.println("狗狗玩飞盘");
    }
    // 非虚方法
    public static void swimming(){
        System.out.println("狗狗在游泳");
    }
    // 子类中定义一个吃饭的静态方法
    public static void eat(){
        System.out.println("狗狗吃骨头");
    }
}
