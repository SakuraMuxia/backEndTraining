package com.generic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class TestCollectGeniric {

    // 创建一个静态方法,参数设置为一个List集合,List集合中的元素的类型为Pet类型
    // 设置List集合中的元素的泛型为Pet
    public static void m1(List<Pet> list){
        System.out.println("m1方法执行");
    }

    // 要求形参为Pet类型以及Pet类型的任意子类
    // ? extends 父类 : 表示泛型可以为父类 以及 父类的任何子类
    // 设置上限
    public static void m2(List<? extends Pet> list){
        System.out.println("m2方法执行");
    }

    // 要求：形参的泛型为Cat 以及 Cat类的任何父类
    // ? super 子类： 表示泛型可以为子类 以及 任何子类的父类
    // 设置下限
    public static void m3(List<? super Cat> list){
        System.out.println("m3方法执行");
    }


    // 静态方法
    public static void main(String[] args) {
        // 泛型为父类
        ArrayList<Pet> list1 = new ArrayList<>();
        Vector<Pet> list2 = new Vector<>();
        LinkedList<Pet> list3 = new LinkedList<>();

        // 泛型为子类，设置上限
        ArrayList<Cat> list4 = new ArrayList<>();

        // 泛型为父类，设置下限
        ArrayList<Animal> list5 = new ArrayList<>();

        // 调用m1静态方法
        m1(list1); // m1方法执行

        // 调用m2静态方法
        m2(list4);

        // 调用m3静态方法
        m3(list5);
    }
}

class Animal <T>{

}

class Pet<T> extends Animal{
    // 类中的方法的形参上使用泛型
    public void m1(T t){
        System.out.println("类中的方法的形参上使用泛型" + t);
    }
    // 类的方法的返回值上使用泛型
    public T m2(T t){
        return t;
    }
}
class Cat extends Pet{
    public String name;
    public int health;
    // 定义方法
    public void eatFish(){
        System.out.println("猫吃鱼");
    }
}
