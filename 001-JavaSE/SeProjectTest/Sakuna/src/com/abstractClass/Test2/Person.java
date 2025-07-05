package com.abstractClass.Test2;

public class Person {
    // 定义实例方法
    public void openCommonDoor(CommonDoor cd){
        cd.open();
    }

    public void closeCommonDoor(CommonDoor cd){
        cd.close();
    }

    public void openSecurityDoor(SecurityDoor sd){
        sd.open();
    }

    public void closeSecurityDoor(SecurityDoor sd){
        sd.close();
    }

    // 以上方式分别针对不同的门的种类编写了开和关的方法 如果后续有更多的门的种类
    // 还需要继续编写更多的方法 这样设计不合理  不符合开闭原则
    // 使用多态的方式简化

    public void openDoor(Door door){
        door.open();
    }

    public void closeDoor(Door door){ // 向上转型，父类引用指向子类对象，多态
        door.close();
    }
    // 多态的情形2：返回值声明为 父类对象，实际返回值为子类类型
    public Door buyDoor(double money){
        if(money > 300){
            return new SecurityDoor();
        }else{
            return new CommonDoor();
        }
    }
}
