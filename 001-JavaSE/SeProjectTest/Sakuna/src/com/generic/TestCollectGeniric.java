package com.generic;

import java.util.List;

public class TestCollectGeniric {
    // 创建一个List集合

    // 创建一个静态方法,参数设置为一个List集合,List集合中的元素的类型为Pet类型
    // 设置List集合中的元素的泛型为Pet
    public static void m1(List<Pet> list){
        System.out.println("m1方法执行");
    }
}

class Pet<T>{
    // 类中的方法的形参上使用泛型
    public void m1(T t){
        System.out.println("类中的方法的形参上使用泛型" + t);
    }
    // 类的方法的返回值上使用泛型
    public T m2(T t){
        return t;
    }
}
class Cat{
    public String name;
    public int health;
    // 定义方法
    public void eatFish(){
        System.out.println("猫吃鱼");
    }

}
