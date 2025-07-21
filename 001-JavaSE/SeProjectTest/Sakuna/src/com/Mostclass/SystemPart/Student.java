package com.Mostclass.SystemPart;

public class Student {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize执行了");
    }
}
