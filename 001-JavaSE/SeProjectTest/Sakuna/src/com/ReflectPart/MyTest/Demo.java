package com.ReflectPart.MyTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo {
    @MyTest
    public void m1(){
        System.out.println("m1方法执行");
    }

    public static void main(String[] args) {
        // 获取class对象
        Class<?> testClass = null;
        try {
            testClass = Class.forName("com.ReflectPart.MyTest.Demo");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // 获取方法
        Method[] methods = testClass.getDeclaredMethods();
        // 创建实例
        Object demo = null;
        try {
            demo = testClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyTest.class)){
                // 执行方法
                try {
                    Object res = method.invoke(demo);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
