package com.object.pet;

public class Cat extends Pet{
    int weight;
    // setter 和 getter方法
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        if (weight < 0){
            System.out.println("重量输入有误，将使用默认值100g");
            this.weight = 100;
        }else{
            this.weight = weight;
        }
    }
    // 无参构造
    public Cat(String name,char sex,int health,int weight){
        // 调用父类中的构造方法,必须放在第一句
        super(health);
        // 调用父类中的属性
        super.name = name;
        // 调用父类中的方法
        super.setSex(sex);
        this.weight = weight;
    }
    // print 方法
    public void print(){
        // 调用父类中的方法
        super.print();
        System.out.println("体重:" + this.weight);
    }
}
