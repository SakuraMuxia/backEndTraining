package com.finalFiled;

public class TestFinalClass {
    // 静态方法
    public static void main(String[] args) {

    }
    // final 修饰类
    final class C{
        public void print(){
            System.out.println("我是final修饰的C类");
        }
    }

    // class D extends C{  // 报错 final修饰的 类 不能被继承。
    //     public void print(){
    //         System.out.println("我是D类");
    //     }
    // }
}
