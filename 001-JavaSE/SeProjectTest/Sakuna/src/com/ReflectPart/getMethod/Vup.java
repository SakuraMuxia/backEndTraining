package com.ReflectPart.getMethod;

public class Vup {
    public String name;
    int age;
    private int height;

    public Vup() {
    }

    public Vup(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
    // 无参方法
    public void m1(){
        System.out.println("无参方法m1 start");
    }
    // 无参方法
    public void m2(int age){
        System.out.println("有参(int)方法m2 start");
    }
    // 无参方法
    private void m3(int age,String name){
        System.out.println("有参(int String)方法m3 start");
    }
    // 无参方法
    protected void m3(int age,String name,int height){
        System.out.println("有参(int String int)方法m3 start");
    }
}
