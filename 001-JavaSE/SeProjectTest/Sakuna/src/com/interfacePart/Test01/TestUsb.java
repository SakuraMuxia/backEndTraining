package com.interfacePart.Test01;

public class TestUsb {
    public static void main(String[] args) {
        // Usb usb = new Usb() // 报错，接口不能 new 对象
        Usb usb = new Mouse(); // 只能通过new 子类（实现类）对象 创建对象，父类引用指向子类对象，多态向上转型的方式
        usb.connect(); // 调用实现类中重写的方法。

        // 顶层父类Usb中 只有 connect 方法
        Usb converter = new UgreenConverter();
        converter.connect(); // 链接方法

        // 创建一个转换器对象
        Converter converter1 = new UgreenConverter();
        converter1.convert(); // 转换方法
        converter1.connect();  // 连接方法


    }
}
