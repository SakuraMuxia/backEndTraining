package com.object.pet;
/**
 * 前提是：必须在访问权限允许的情况下访问
 * 子类访问父类的属性
 * super.属性
 *
 * 子类访问父类的方法
 * super.方法名()
 *
 * 子类访问父类的构造方法
 * super()或super(name,age,sex)
 */

public class Dog extends Pet{
    String variety;
    // 有参构造
    public Dog(String name,char sex,int health,String variety) {
        // 调用父类中有参构造方法
        super(name,sex,health);
        this.variety = variety;
    }
    // get和set方法
    public String getVariety() {
        return variety;
    }
    public void setVariety(String variety) {
        this.variety = variety;
    }
    // print方法
    public void print(){
        // 调用父类中的方法
        super.print();
        System.out.println("品种:"+this.variety);
    }
}
