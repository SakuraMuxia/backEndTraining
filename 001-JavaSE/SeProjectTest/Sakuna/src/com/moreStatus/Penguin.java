package com.moreStatus;

public class Penguin extends Pet{
    private char gender;

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Penguin(String name, int health, int love, char gender) {
        super(name, health, love);
        this.gender = gender;
    }

    public Penguin() {
    }

    // 重写父类方法

    @Override
    public void cure() {
        System.out.println("企鹅看病，打针，吃小鱼，健康值恢复");
        this.setHealth(100);

    }

    // 企鹅冲QB方法
    public void payQB(){
        System.out.println("企鹅冲了100QB");
    }

}
