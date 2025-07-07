package com.interfacePart.Test01;

public class Mouse implements Usb{
    @Override
    public void connect() {
        System.out.println("鼠标已连接~");
    }
}
