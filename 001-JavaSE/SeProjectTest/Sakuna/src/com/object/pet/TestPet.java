package com.object.pet;

public class TestPet {
    public static void main(String[] args) {
        // 实例化对象
        Dog dog = new Dog("奈奈",'雌',100,"金毛");
        dog.print();

        Cat cat = new Cat("月月",'雌',99,205);
        cat.print();
    }
}
