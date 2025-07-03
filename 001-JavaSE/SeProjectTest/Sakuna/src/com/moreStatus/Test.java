package com.moreStatus;

/*
 * 父类引用指向子类对象属于向上转型，此时通过父类引用，
 *  可以访问的是子类重写或者继承父类的方法
 *  不能访问子类独有的方法 如需访问 则必须向下转型
 *
 * 向下转型：
 * 是将指向子类对象的父类引用 转换为 子类类型
 * 而不是 将指向父类对象的父类引用 转换为子类类型
 * 总结：必须先向上转型 才可以向下转型  否则将出现类型转换异常  ClassCastException
 *
 * 因为异常会中断程序 所以 在实际开发中我们会使用instanceof关键字 在类型转换之前
 * 进行判断 如果类型正确 则转换 不正确 则不转
 *  用法： 对象名 instanceof 类名
 *  表示判断左侧的对象是否属于右侧的类型
 */

public class Test {
    public static void main(String[] args) {
        // 创建宠物类
        Pet pet = new Dog("十一月",98,39,"乌萨齐"); // 向上转型
        // 判断类型
        if (pet instanceof Dog){ // 判断类型正确, pet 属于 Dog类型
            // pet对象强转为dog对象 === 父类引用转为子类对象
            Dog dog = (Dog) pet;
            dog.playFlyDisc();
        }
        // 没有向上转型
        Pet p1 = new Pet();
        if(p1 instanceof  Dog){ // 判断类型不正确, pet 不属于 Dog类型
            Dog dog1 = (Dog)p1; // 转型错误 有异常 ClassCastException 报错
            System.out.println("dog1 = " + dog1);
        }else{
            System.out.println("类型不匹配");
        }
        System.out.println("程序结束");
    }
}
