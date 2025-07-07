package com.interfacePart.Test01;

public class UgreenConverter extends Converter{
    @Override
    public void convert() {
        System.out.println("绿联转换器执行水晶头转换USB接口");
    }

    @Override
    public void connect() {
        System.out.println("绿联转换器连接USB接口~");
    }
}
