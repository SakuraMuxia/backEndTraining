package com.abstractClass.Test2;

public class CommonDoor extends Door{
    @Override
    public void open() {
        System.out.println("普通门开门，插入钥匙，轻轻一转，zhi~ya一声，门开了");
    }

    @Override
    public void close() {
        System.out.println("普通门关门，随手关门，duang的一声，门关了");
    }

}
