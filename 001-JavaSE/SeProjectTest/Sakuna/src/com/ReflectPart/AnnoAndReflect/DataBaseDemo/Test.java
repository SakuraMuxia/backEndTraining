package com.ReflectPart.AnnoAndReflect.DataBaseDemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        // 获取class类对象
        try {
            Class<?> dataClass = Class.forName("com.ReflectPart.AnnoAndReflect.DataBaseDemo.DataInfo");
            // 获取属性
            Field declaredField = dataClass.getDeclaredField("password");
            Annotation[] anns = declaredField.getDeclaredAnnotations();
            for (Annotation ann : anns) {
                System.out.println(ann);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

    }
}
