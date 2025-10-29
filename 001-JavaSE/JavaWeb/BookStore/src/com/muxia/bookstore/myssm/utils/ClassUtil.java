package com.muxia.bookstore.myssm.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ClassUtil {
    // 获取 Class对象 全限定名
    public static Class getEntityClass(String entityName){
        try {
            return Class.forName(entityName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    // 通过反射创建Class对象的实例
    public static Object createInstance(String entityName){
        try {
            return getEntityClass(entityName).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 通过反射给实例的属性赋值(ioc注入使用)
    public static void setSimpleProperty(Object obj,String propertyName,Object propertyValue){
        try {
            Field field = obj.getClass().getDeclaredField(propertyName);
            // 忽略警告
            field.setAccessible(true);
            // 赋值
            field.set(obj,propertyValue);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    // 通过反射给实例的属性赋值（普通方法使用）
    public static void setProperty(Object obj,String propertyName,Object propertyValue){
        try {
            Field field = obj.getClass().getDeclaredField(propertyName);
            // 如果这个 field 是 String Integer Boolean Double 类型，那么可以直接赋值
            // 如果这个 field 是 UserBasic Book 等自定一类型，不可以直接赋值，而是new出实例对象，然后再进行赋值
            String fieldTypeName = field.getType().getName(); // java.lang.String
            if (propertyValue != null){
                if (isMyType(fieldTypeName)){
                    // field.getClass() 返回的是 Field 类本身的 Class 对象
                    // Class<? extends Field> fieldClass1 = field.getClass();
                    Class<?> fieldClass = field.getType();
                    // 根据ID创建实例，使用带参的构造方法
                    Constructor constructor = fieldClass.getDeclaredConstructor(Integer.class);
                    // 创建实例
                    propertyValue = constructor.newInstance(propertyValue);

                }
                // 忽略警告
                field.setAccessible(true);
                // 赋值
                field.set(obj,propertyValue);
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
    // 判断是否是自定义类型
    public static boolean isMyType(String className){
        switch (className){
            case "java.lang.String":
            case "java.lang.Double":
            case "java.lang.Integer":
            case "java.lang.Long":
            case "java.util.Date":
            case "java.sql.Date":
            case "java.time.LocalDateTime":
                return false;
            default:
                return true;
        }
    }

}
