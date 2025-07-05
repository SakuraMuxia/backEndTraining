package com.abstractClass.Test1;

// 定义一个抽象类
public abstract class Animal {
    // 属性
    private String animalType;
    // 构造方法
    public Animal(){}
    public Animal(String animalType) {
        this.animalType = animalType;
    }
    // 实例方法
    public String getAnimalType() {
        return animalType;
    }
    // 实例方法
    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }
    // 静态方法
    public static void m1(){
        System.out.println("Animal类中的m1方法 ");
    }
    // 抽象方法
    public abstract void eat();
}
