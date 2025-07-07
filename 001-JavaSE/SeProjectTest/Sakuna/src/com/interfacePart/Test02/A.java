package com.interfacePart.Test02;

public interface A {
    void m1();
}

interface B{
    void m2();
}

interface C{
    void m3();
}

interface D{
    void m4();
}

// 一个接口可以继承多个接口，这种情况很少出现。
interface F extends A,B,C,D{
    void m5();
}

// 一个类可以实现多个接口
class E implements A,B,C,D{
    // 实现4个方法
    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }

    @Override
    public void m3() {

    }

    @Override
    public void m4() {

    }
}