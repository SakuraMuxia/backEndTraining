package com.moreStatus;

public class Master {

    // 获得 一个 企鹅对象
    public Penguin getPenguin(){
        Penguin penguin = new Penguin("小白", 100, 100, '雄');
        return penguin;
    }
    // 获得 一个 狗狗对象
    public Dog getDog(){
        Dog dog = new Dog("大黄", 100, 100, "金毛");
        return dog;
    }
    // 获得 一个 宠物对象
    // 使用多态的方式
    // 父类作为声明返回值，实际返回值为子类类型
    public Pet getPet(String str){
        if (str.equals("No1")){
            Penguin penguin = new Penguin("小白", 100, 100, '雄');
            return penguin;
        } else{
            Dog dog = new Dog("大黄", 100, 100, "金毛");
            return dog;
        }
    }
}
