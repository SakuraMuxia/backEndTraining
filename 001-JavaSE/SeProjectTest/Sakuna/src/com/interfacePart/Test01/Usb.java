package com.interfacePart.Test01;

public interface Usb {
    // 接口内 默认为 全局静态变量 即 public static final 修饰
    int A = 100;

    // 不能写构造方法
    // public Usb (){
    //
    // }

    // 接口中的方法默认都为全局抽象方法 即不管是否书写均使用public abstract修饰
    void connect();
}
