package com.yuluo;

import java.util.Arrays;

public class ValuePass {
    // 值传递和引用传递的区别？
    public static void fun(int num){
        num++;
    }
    public static void fun2(int [] nums){
        for (int i = 0; i < nums.length; i++) {
            nums[i]++;
        }
    }

    public static void main(String[] args) {
        int a = 10;
        // 调用fun:基本数据类型 参数传递的是值
        fun(a);
        System.out.println("a = " + a); // 10 修改的是num a的值并没有发生改变
        // 调用fun2:引用数据类型 参数传递的值地址
        int [] b = {1,2,3,4};
        fun2(b);
        System.out.println("b = "+ b); // b = [I@4554617c
        System.out.println("b的值为"+ Arrays.toString(b)); // b的值为[2, 3, 4, 5]
    }
}
