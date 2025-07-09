package com.throwsPart.Test01;

/**
 * 运行时异常(RuntimeException及其子类)：调用者不必处理
 *  *  检查异常(除了运行时异常以外的其他异常就属于检查异常CheckedException)：调用者必须处理
 *  *    两种处理方式：
 *  *       1.使用try-catch处理
 *  *       2.继续在main方法上声明 属于声明给JVM虚拟机 (其实属于不处理)
 *
 *  throw:用于在方法体内抛出异常,一句只能抛出一个异常。
 *    根据抛出的异常类型不同 需要做出不同的处理
 *       如果抛出的为运行时异常 则方法上不必声明
 *       如果抛出的为检查异常 则必须在方法上声明
 *
 */

import java.util.InputMismatchException;

public class TestThrows {
    // 通过 throws 声明当前方法可能会出现哪些异常
    // 可以声明多个异常,使用逗号分割
    public static void m1() throws InputMismatchException,ArithmeticException { // 运行时异常(RuntimeException及其子类)
        System.out.println("m1方法执行");
    }
    public static void m2() throws ClassNotFoundException{ // 检查异常
        System.out.println("m2方法执行");
    }
    // 方法调用者根据声明的异常类型不同会做出不同的处理
    public static void main(String[] args) {
        m1(); // 调用m1方法
        try{
            m2();
        }catch (ClassNotFoundException e){ // 检查异常需要捕获处理
            throw new RuntimeException(e);
        }
    }

}
