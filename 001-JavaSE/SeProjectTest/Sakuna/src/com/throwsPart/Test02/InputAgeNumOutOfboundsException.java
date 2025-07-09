package com.throwsPart.Test02;

// 自定义 异常 继承 异常父类
public class InputAgeNumOutOfboundsException extends RuntimeException{

    // 有参构造完成异常信息的初始化
    public InputAgeNumOutOfboundsException(String message) {
        // 使用父类中构造方法
        super(message);
    }
}
