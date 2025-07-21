package com.baoZhuangPart.Test01;

/**
 *  数据类型：   byte short  int     long float double boolean char
 *  对应的包装类：Byte Short  Integer Long Float Double Boolean Character
 *
 *  包装类构造方法：
 *  所有包装类都可将与之对应的基本数据类型作为参数，来构造它们的实例
 *  除Character类外，其他包装类可将一个字符串作为参数构造它们的实例
 *
 *  使用字符串构造Number子类实例,字符串不能为null,并且必须可以解析为正确的数值才可以,否则将报NumberFormatException
 */

public class TestConstructor {
    public static void main(String[] args) {
        // 默认一个 整数是 int 类型 需要强制转为 byte类型
        Byte b1 = new Byte((byte)120); // 使用基本数据类型来创建对象
        System.out.println("b1 = " + b1);

        byte b = 110;
        Byte b2 = new Byte(b); // 所有包装类都可将与之对应的基本数据类型作为参数，来构造它们的实例
        System.out.println("b2 = " + b2);

        Byte b3 = new Byte("11"); // 除Character类外，其他包装类可将一个字符串作为参数构造它们的实例
        System.out.println("b3 = " + b3);

        System.out.println("------------------------------------");

        Short s1 = new Short((short)345);
        System.out.println("s1 = " + s1);

        Short s2 = new Short("234");
        System.out.println("s2 = " + s2);

        System.out.println("------------------------------------");

        Integer i1 = new Integer(1234);
        System.out.println("i1 = " + i1);

        Integer i2 = new Integer("3456");
        System.out.println("i2 = " + i2);

        System.out.println("------------------------------------");

        Long l1 = new Long(4657);
        System.out.println("l1 = " + l1);

        Long l2 = new Long("7829092");
        System.out.println("l2 = " + l2);

        System.out.println("------------------------------------");

        Boolean bl1 = new Boolean(true);
        System.out.println("bl1 = " + bl1);

        Boolean bl2 = new Boolean(false);
        System.out.println("bl2 = " + bl2);

        // 使用字符串构造Boolean实例 不区分大小写 如果内容为true 则表示为true
        // 其他的任何字符串都表示为false 包括null
        Boolean bl3 = new Boolean(null);
        System.out.println("bl3 = " + bl3); // false
        Boolean bl4 = new Boolean("true");
        System.out.println("bl4 = " + bl4); // true

        System.out.println("------------------------------------");
        Character ch1 = new Character('a');
        System.out.println("ch1 = " + ch1);

    }

}
