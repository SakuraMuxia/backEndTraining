package com.object.pet;
/**
 *  使用此子类继承父类，调用继承自父类的print方法 存在如下两个小问题
 *  1. 宠物信息不完善，父类无法访问子类中的 属性
 *  2. 宠物身份不明确，父类无法打印子类中的 name
 */
public class TestPet {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.setVariety("金毛");
        dog1.setHealth(99);
        dog1.setName("烈烈");
        dog1.setSex('雄');
        dog1.print();
        System.out.println("*******");

        Cat cat1 = new Cat();
        cat1.setWeight(206);
        cat1.setHealth(98);
        cat1.setName("九月");
        cat1.setSex('雌');
        cat1.print();
        System.out.println("*******");
    }
}
