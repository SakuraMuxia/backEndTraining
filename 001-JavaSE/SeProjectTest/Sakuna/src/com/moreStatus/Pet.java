package com.moreStatus;

public class Pet {
    protected String name;
    protected int health;
    protected int love;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public Pet(String name, int health, int love) {
        this.name = name;
        this.health = health;
        this.love = love;
    }
    public Pet() {
    }
    public void print(){
        System.out.println("宠物的名字是：" + name);
        System.out.println("宠物的健康值是：" + health);
        System.out.println("宠物的亲密值是：" + love);
    }

    public void cure(){
        System.out.println("宠物看病");
    }
    // 父类中定义一个吃饭的静态方法
    public static void eat(){
        System.out.println("宠物吃饭");
    }
}
