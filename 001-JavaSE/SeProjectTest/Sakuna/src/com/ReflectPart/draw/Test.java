package com.ReflectPart.draw;

public class Test {
    public static void main(String[] args) {
        // 创建mas对象
        Master mas = new Master();
        // 获取宠物对象
        Pet pet = mas.getPet("com.ReflectPart.draw.Dog");
        System.out.println("pet = " + pet); // pet = com.ReflectPart.draw.Dog@4554617c
    }
}
