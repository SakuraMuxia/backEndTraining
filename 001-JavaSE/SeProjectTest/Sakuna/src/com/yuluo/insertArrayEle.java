package com.yuluo;

import java.util.Arrays;

public class insertArrayEle {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        // 方法
        int[] newArray = insertArray(nums, 2,18);
        System.out.print(Arrays.toString(newArray));
    }
    // 插入元素的方法
    public static int[] insertArray(int [] oldArrays,int index,int val){
        // 下标不能小于0 或者 不能大于数组的长度
        if(index < 0 || index > oldArrays.length){
            System.out.println("下标不合法");
            // 如果下标不合法 则将传入的数组 直接返回 表示没有做任何操作
            return oldArrays;
        }
        // 准备一个长度+1的数组 用于插入元素
        int [] newArray = new  int[oldArrays.length + 1];
        // 遍历开始移动元素
        for(int i = 0;i < oldArrays.length;i++){
            // 情况1 小于插入下标 则直接复制到新数组中
            if(i < index){
                newArray[i] = oldArrays[i];
            }else{ // 情况2  大于或者等于插入下标 则移动到新数组的+1位置
                newArray[i + 1] = oldArrays[i];
            }
        }
        // 空缺位插入指定的元素
        newArray[index] = val;
        return newArray; // 将新数组返回
    }
}
