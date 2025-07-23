package com.insideClassPart;


public class Outer2 {
    public static void main(String[] args) {
        // 直接new一个实现类，这个实现类就是匿名局部内部类
        A a = new A() {
            @Override
            public void m1() {
                System.out.println("匿名内部类 " + args); // 匿名内部类对象
            }
        };
        // 调用接口中的方法
        a.m1();

        B b = new B() {
            @Override
            public void m2() {
                System.out.println("匿名内部类 ");
            }
        };
        // 调用抽象类中的方法
        b.m2();

        // 创建线程时，快捷方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类的方式实现Runnable实现类");
            }
        }).start();
    }
}

// 接口
interface A {
    void m1();
}

// 抽象类
abstract class B{
    public abstract void m2();
}