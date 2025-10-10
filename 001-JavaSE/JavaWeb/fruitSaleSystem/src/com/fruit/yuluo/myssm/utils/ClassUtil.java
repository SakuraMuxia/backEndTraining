package com.fruit.yuluo.myssm.utils;

import java.lang.reflect.Field;

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

    // 通过反射给实例的属性赋值
    public static void setProperty(Object obj,String propertyName,Object propertyValue){
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
}
