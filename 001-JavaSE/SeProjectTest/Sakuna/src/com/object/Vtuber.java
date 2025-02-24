package com.object;

public class Vtuber {
    // 实例变量 属性
    String name;
    int age;
    char sex;
    double weight;
    double height;
    String hobby;
    // 实例方法
    public void singing(){
        System.out.println("海想列车 只在梦中见过一点点~~~");
    }
    public void gaming(){
        System.out.println("Apex start!!!");
    }
    public void myInfo(){
        // 调用实例方法 方式1 通过this.
        this.gaming();
        // 调用实例方法 方式2 直接调用
        singing();
        System.out.println("我的名字是 " + name);
        System.out.println("我的年龄是 " + age);
        System.out.println("我的身高是 " + height);
        System.out.println("我的体重是 " + weight);
        System.out.println("我的性别是 " + sex);
        System.out.println("我的爱好是 " + hobby);
    }
    // 构造方法 无参
    public Vtuber(){
        System.out.println("无参构造方法执行!");
    }
    // 构造方法 有参
    public Vtuber(String name,int age){
        System.out.println("有参构造方法one 执行!");
        this.name = name;
        this.age = age;
    }
    // 构造方法 有参 构造方法重载
    public Vtuber(double height,double weight,char sex,String hobby){
        // 访问构造方法
        this("yousa",18);
        System.out.println("有参构造方法two 执行!");
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.hobby = hobby;
    }
    public static void main(String[] args) {
        // 格式：类名 对象名 =  new 类名();
        Vtuber yousa = new Vtuber(148,45,'女',"Sing and Stream");
        // 调用方法
        yousa.myInfo();
    }
}
