package com.finalFiled;

/**
 * final修饰的方法不能被子类重写
 */
public class TestFinalMethod {
    class A{
        public final void m1(){
            System.out.println("A类m1方法");
        }

        public void m2(){
            System.out.println("A类m2方法");
        }
    }

    class B extends A{
        public void m2(){
            System.out.println("A类m2方法重写");
        }

        // public void m1(){ // 报错，不能重写父类 final 修饰的方法
        //     System.out.println("A类m1方法重写");
        // }

    }
}
