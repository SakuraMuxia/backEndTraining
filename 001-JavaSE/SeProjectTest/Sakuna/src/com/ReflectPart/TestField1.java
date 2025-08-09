package com.ReflectPart;

import java.lang.reflect.Field;

public class TestField1 {
    public static void main(String[] args) throws Exception {
        // 通过反射获取 类的Class对象
        Class<?> aClass = Class.forName("com.ReflectPart.Vup");
        // 获取所有的已定义的字段对象 返回值为字段数组
        Field[] declaredFields = aClass.getDeclaredFields();
        // 遍历属性数组
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName() + "-" + declaredField.getType() + "-" + declaredField.getModifiers());
        }
        // 根据名称获取到单个字段对象
        Field field1 = aClass.getDeclaredField("height");
        // 通过Vup类 Class对象 创建 up类实例
        Object obj = aClass.newInstance();
        // 表示忽略JVM的安全检查 即可以不在同类中访问私有属性
        field1.setAccessible(true);
        // 属性赋值
        // 第一个参数 表示给哪个对象的此属性赋值
        // 第二根参数 具体值
        field1.set(obj,12);

        // 获取属性值 参数表示获取哪个对象的此属性的值
        System.out.println(field1.get(obj));
    }
}
