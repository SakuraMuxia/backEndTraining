package com.insideClassPart;

// 静态内部类
public class Pet {
    private String name;
    private int age;
    // 实例级别
    public void eat(){
        System.out.println("外部类-实例-吃饭");
    }
    // 静态方法
    public static void sleep(){
        System.out.println("外部类-静态-睡觉");
    }
    // 静态内部类
    public static class Address{
        private String country;
        private String city;

        // 实例方法
        public void printCountry(){
            // 创建外部类对象
            Pet pet = new Pet();
            // 访问外部类实例方法
            pet.eat();
            // 访问外部类属性
            pet.name = "九月";
            // 访问内部类属性
            this.city = "杭州";
            System.out.println("内部类-实例-打印国家");
            System.out.println(pet.name);
            System.out.println(city);
        }
        // 静态方法
        public static void printCity(){
            System.out.println("内部类-静态-打印城市");
        }
    }
}
