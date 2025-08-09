package com.ReflectPart.draw;

public class Master {
    // 抽奖获取宠物方法，参数是子类名称 包名+类名全限定名称
    public Pet getPet(String subClassName) {
        Pet pet = null;
        try {
            // 通过类类对象
            Class<?> aClass = Class.forName(subClassName);
            // 创建实例对象，默认使用的是无参构造方法创建
            Object obj = aClass.newInstance();
            // 判断类型，然后转换
            if (obj instanceof Pet){
                pet = (Pet) obj;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        // 把实例返回
        return pet;
    }
}
