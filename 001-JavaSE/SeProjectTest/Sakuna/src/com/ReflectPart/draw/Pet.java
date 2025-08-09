package com.ReflectPart.draw;
/**
 * 宠物类 父类
 */
public class Pet {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet(String name) {
        this.name = name;
    }

    public Pet() {

    }

    public void print(){
        System.out.println("宠物的名字是：" + name);
    }
}
