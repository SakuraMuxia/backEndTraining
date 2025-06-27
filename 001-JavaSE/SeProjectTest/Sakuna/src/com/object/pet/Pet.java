package com.object.pet;

public class Pet {
    // 属性私有
    private String name;
    private char sex;
    private int health;


    // 方法公开
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
    // 父类中无法访问子类中的成员
    public void print(){
        System.out.println("宠物名字是"+name);
        System.out.println("宠物健康值是"+health);
        System.out.println("宠物性别是"+sex);
    }
}
