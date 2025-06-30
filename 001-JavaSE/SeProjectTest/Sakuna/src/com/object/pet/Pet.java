package com.object.pet;

public class Pet {
    // 属性
    protected String name;
    protected char sex;
    public int health;
    // 父类中的无参构造方法
    public Pet(){}
    // 父类的有参构造方法
    public Pet(String name,char sex,int health){
        this.name = name;
        this.sex = sex;
        this.health = health;
    }
    // 父类中的有参构造
    public Pet(int health){
        this.health = health;
    }
    // getter和setter方法
    public void setHealth(int health) {
        if(health > 0 && health < 100){
            // 设置默认值
            this.health = health;
        }else {
            System.out.println("参数设置有误,使用默认健康值:60");
            this.health = 60;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(char sex) {
        if(sex == '雌' || sex == '雄'){
            this.sex = sex;
        }else{
            System.out.println("参数设置有误,使用默认性别：雄");
            this.sex = '雄';
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public char getSex() {
        return sex;
    }
    // 父类中print方法
    public void print(){
        System.out.println("名字:"+name);
        System.out.println("健康值:"+health);
        System.out.println("性别:"+sex);
    }
}
