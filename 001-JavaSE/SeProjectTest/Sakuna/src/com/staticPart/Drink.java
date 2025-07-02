package com.staticPart;

public class Drink {
    String name;
    static int water = 100;
    // 构造方法
    public Drink(String name) {
        this.name = name;
    }

    public Drink() {
    }

    // 喝水方法
    public void getWater(){
        if(water > 0 ){
            water -= 2;
            System.out.println(name + "接水2L,剩余" + water +"L");
        }else{
            System.out.println("没水了");
        }
    }
    // 测试类
    public static void main(String[] args) {
        // 实例化1
        Drink drink = new Drink("yousa");
        drink.getWater(); // yousa接水2L,剩余98L
        // 通过对象名访问 静态属性 （不推荐）
        drink.water = 200;
        // 通过类名访问静态属性,在本类中直接访问
        water = 201;
        // 通过类名访问静态属性
        Drink.water = 202;

        // 实例化2
        Drink drink2 = new Drink("Reine");
        drink2.getWater(); // Reine接水2L,剩余198L
    }
}
