package com.yuluo;

import java.util.Arrays;

public class ArrayTrain {
    public static void main(String[] args) {
        // 数组扩容
        int [] oldArr = {15,16,17,18};
        // 创建比之前大的新数组
        int [] newArr = new int [oldArr.length * 2];
        // 复制新数组
        for (int i = 0; i < oldArr.length; i++) {
            newArr[i] = oldArr[i];
        }
        // 地址替换
        oldArr = newArr;
        // 设置新数组
        newArr[7] = 28;
        System.out.println(oldArr);// [I@4554617c
        System.out.println(newArr); // [I@4554617c
        System.out.println(Arrays.toString(newArr)); // [15, 16, 17, 18, 0, 0, 0, 28]
    }
}
