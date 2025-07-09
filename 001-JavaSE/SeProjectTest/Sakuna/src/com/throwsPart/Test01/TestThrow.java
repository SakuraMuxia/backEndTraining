package com.throwsPart.Test01;

/**
 *  throw:用于在方法体内抛出异常,一句只能抛出一个异常。
 *    根据抛出的异常类型不同 需要做出不同的处理
 *       如果抛出的为运行时异常 则方法上不必声明
 *       如果抛出的为检查异常 则必须在方法上声明
 */
public class TestThrow {
    // 抛出的是运行时异常
    public static void m3(int age){
        if(age < 0 || age > 130){
            // 抛出 运行时异常
            throw new RuntimeException("年龄不合法");
        }
    }
    // 抛出的是 检查性异常，需要在方法上做声明
    public static void m4(int age) throws Exception{
        if(age < 0 || age > 130){
            // 抛出 检查型异常
            throw new Exception("年龄不合法");
        }
    }

    public static void main(String[] args) {
        // 调用m3方法
        m3(18);
        // 调用m4方法，检查型异常，必须处理。
        try{
            m4(189);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
