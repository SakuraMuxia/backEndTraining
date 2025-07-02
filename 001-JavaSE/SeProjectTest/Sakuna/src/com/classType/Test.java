package com.classType;

public class Test {
    public static void main(String[] args) {
        // 创建对象
        Student stu1 = new Student();
        stu1.setName("aqua");
        stu1.setAge(5);
        // 创建地址对象
        Address add1 = new Address();
        add1.setProvince("日本省");
        add1.setArea("东京都");
        add1.setCity("歌舞伎町");
        // 设置地址属性
        stu1.setAddress(add1);

        // 关于空指针异常
        // 只要使用指向为null的引用 调用任何的属性或者方法 就会产生空指针异常
        // 创建 hobby数组对象
        Hobby [] hobbies = new Hobby[3];
        // 创建 hobby元素对象
        hobbies[0] = new Hobby();
        hobbies[0].setHobbyType("电子竞技");
        hobbies[0].setHobbyName("LOL");

        hobbies[1] = new Hobby();
        hobbies[1].setHobbyType("文艺类");
        hobbies[1].setHobbyName("尬舞");

        hobbies[2] = new Hobby();
        hobbies[2].setHobbyType("体育类");
        hobbies[2].setHobbyName("唱跳RAP 篮球");
        // 打印信息
        for (int i = 0; i < hobbies.length; i++) {
            System.out.println(hobbies[i]);
        }
        // 设置 爱好属性
        stu1.setHobby(hobbies);

        // 打印信息
        System.out.println("------------------------------------------------------------");
        System.out.println(stu1.getName());
        System.out.println(stu1.getAge());
        System.out.println(stu1.getAddress());
        System.out.println(stu1.getAddress().getProvince());
        System.out.println(stu1.getAddress().getCity());
        System.out.println(stu1.getAddress().getArea());
        System.out.println("------------------------------------------------------------");
        // 获取stu1的爱好类对象数组
        Hobby[] hobbies1 = stu1.getHobby();

        for (int i = 0; i < hobbies1.length; i++) {
            // 调用爱好类中的toString方法重写
            System.out.println(hobbies1[i]);
            System.out.println(hobbies1[i].getHobbyType());
            System.out.println(hobbies1[i].getHobbyName());
        }
        System.out.println("------------------------------------------------------------");
        // 打印stu1对象
        System.out.println(stu1);
    }
}
