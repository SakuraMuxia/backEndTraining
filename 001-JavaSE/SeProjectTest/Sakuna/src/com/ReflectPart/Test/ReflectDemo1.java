package com.ReflectPart.Test;

// 万物皆对象：类，属性，方法，构造器也属于对象
//

/**
 * java.lang.Class 类类 每一个类都将在类加载阶段自动产生此类的实例
 *
 *
 */

public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 方式1：通过Class.forName 获取Class对象 ( String类型的 全限定名)
        // 由于是 运行时获取Class类对象，所以无法得知Class类对象的类型
        Class<?> aClass = Class.forName("com.ReflectPart.Test.Singer");
        System.out.println("aClass = " + aClass); // class com.ReflectPart.Test.Singer

        // 方式2：使用类名.class属性 获取Class对象
        // 在编译时，就得知Class类对象的类型，所以可以提前得知Class类型的对象，泛型为Singer
        Class<Singer> singerClass = Singer.class;
        System.out.println("singerClass = " + singerClass); // class com.ReflectPart.Test.Singer

        // 方式3：使用Object类中getClass() 方法，获取Class对象（实例方法）
        // 在编译时，可以得知Class类型的对象为Singer类或Singer类的子类，
        Singer hanser = new Singer();
        Class<? extends Singer> aClass1 = hanser.getClass();
        System.out.println("aClass1 = " + aClass1); // class com.ReflectPart.Test.Singer

    }
}
