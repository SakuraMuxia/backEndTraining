package com.object;

public class Singer {
    String name;
    char sex;
    int age;
    String works;
    String interest;
    String constellation;

    public void sing(){
        System.out.println("浪奔~浪流~万里涛涛江水永不休~");
    }
    public void showWorks(){
        System.out.println(name + " 的作品有 " + works);
    }
    public Singer(String name,int age,char sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public Singer(String name,int age,char sex,String works,String interest,String constellation){
        // 调用上边的构造方法
        this(name,age,sex);
        this.works = works;
        this.interest = interest;
        this.constellation = constellation;
    }
    public static void main(String[] args) {

        Singer singer1 = new Singer("yousa",18,'女',"勾指起誓","唱歌","天蝎座");
        singer1.showWorks();
    }
}
