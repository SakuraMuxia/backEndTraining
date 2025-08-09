package com.ReflectPart.getMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class TestGetMethod1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        // 创建类Class对象
        Class<?> vupClass = Class.forName("com.ReflectPart.getMethod.Vup");
        // 获取本类中已定义的方法(私有方法)
        Method m31 = vupClass.getDeclaredMethod("m3",int.class, String.class, int.class);
        Method[] declaredMethods = vupClass.getDeclaredMethods();
        // 创建类对象实例
        Object o = vupClass.newInstance();
        // 执行方法
        // 忽略JVM警告
        m31.setAccessible(true);
        m31.invoke(o,18,"hanser",165);
        // 遍历所有本类方法
        for (Method declaredMethod : declaredMethods) {
            //打印信息
            String name = declaredMethod.getName();
            int parameterCount = declaredMethod.getParameterCount();
            System.out.println(name + " " + parameterCount);
        }

    }
}
