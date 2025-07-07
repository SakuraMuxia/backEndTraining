package com.interfacePart.Test04;

public class TestPrinter {
    public static void main(String[] args) {
        // 创建打印机实例
        Printer hp = new Printer();
        // 创建纸张实例
        Paper a4 = new A4();
        Paper b5 = new B5();
        // 创建墨盒实例
        InkBox blackInk = new BlackInkBox();
        InkBox colorInk = new ColorInkBox();
        // 设置打印机属性
        hp.setPaper(a4);
        hp.setInkBox(colorInk);
        // 调用打印机实例属性
        hp.print(); // 使用彩色墨盒在A4纸张上打印
    }
}
