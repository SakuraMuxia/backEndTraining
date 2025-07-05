package com.abstractClass.Test2;

public class TestPersion {
    public static void main(String[] args) {
        Person person = new Person();
        // 创建普通门实例
        CommonDoor commonDoor = new CommonDoor();
        commonDoor.setBrand("小金刚");
        commonDoor.setPrice(200);
        // 创建防盗门实例
        SecurityDoor securityDoor = new SecurityDoor();
        securityDoor.setBrand("大金刚");
        securityDoor.setPrice(500);
        // 人开门
        person.openDoor(commonDoor);
        person.openDoor(securityDoor);
        // 人关门
        person.closeDoor(commonDoor);
        person.closeDoor(securityDoor);
        System.out.println("-------------------------------------------------------");

        // 多态情形1：向上转型，父类引用指向子类对象，多态
        Door door = person.buyDoor(500); //
        door.open(); // 门打开了
        door.close(); // 门关闭了

        // 多态情形3：父类类型数组，子类为元素
        Door [] doors = new Door[2];
        doors[0] = new CommonDoor();
        doors[1] = new SecurityDoor();

        // Door{brand='null', price=0.0}
        // Door{brand='null', price=0.0}
        for (int i = 0; i < doors.length; i++) {
            System.out.println(doors[i].toString());
        }
    }
}
