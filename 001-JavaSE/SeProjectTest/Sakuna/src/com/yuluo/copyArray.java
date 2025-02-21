package com.yuluo;

import java.util.Arrays;

public class copyArray {
    public static void main(String[] args) {
        int [] oldArr = {12,13,14,15};
        int [] newArr = new int[10];
        int [] ageArr = {13,13,13};
        // 使用 System.arraycopy 方法
        // 参数为 旧数组 下标 新数组 下标 长度
        // 无返回值
        System.arraycopy(oldArr,1,newArr,2,2);
        System.out.println("新数组为 " + Arrays.toString(newArr));
        // 使用 Arrays.copyOf 方法
        // 有返回值
        int [] newAgeArr = Arrays.copyOf(ageArr,10);
        System.out.println("新数组1为 " + Arrays.toString(newAgeArr));
    }
}
