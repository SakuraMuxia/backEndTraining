package com.ReflectPart.getConstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// 测试Contructor获取构造方法
public class TestContructor {
    public static void main(String[] args) {

        try {
            Class<?> vupClass = Class.forName("com.ReflectPart.Test.Vup");
            Constructor<?>[] declaredConstructors = vupClass.getDeclaredConstructors();
            // 遍历
            for (Constructor<?> con : declaredConstructors) {
                System.out.println(con.getName() + "---" + con.getParameterCount());
            }
            Constructor<?> con1 = vupClass.getDeclaredConstructor(String.class);
            // 忽略告警
            con1.setAccessible(true);
            // 创建Vup实例对象
            Object obj1 = con1.newInstance("赵四");
            // 打印
            System.out.println("obj1 = " + obj1);

        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
