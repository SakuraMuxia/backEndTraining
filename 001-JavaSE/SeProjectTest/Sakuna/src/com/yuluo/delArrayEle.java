package com.yuluo;

import java.util.Arrays;

public class delArrayEle {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        // 调用删除方法 删除下标 为2
        int[] delete = delete(nums,2);
        System.out.println(Arrays.toString(delete));
    }

    // 删除元素 旧数组 下标
    public static int[] delete(int[] oldArray, int index) {
        if (index < 0 || index > oldArray.length) {  // 判断下标 如果小于0 或者 大于等于数组长度 表示不合法 因为删除 只能删除有效范围以内的
            System.out.println("下标非法");
            return oldArray; // 直接将传入的原数组返回 表示没有做任何操作
        }
        // 准备一个长度-1的数组 用于删除之后复制元素
        int[] newArray = new int[oldArray.length - 1];
        // 循环遍历开始复制元素
        for (int i = 0; i < newArray.length; i++) {
            if (i < index) { // 情况1 小于删除的下标 直接复制
                newArray[i] = oldArray[i];
            } else {  // 情况2 大于等于删除下标 则直接将原数组的+1位置 移动到新数组的后续位置 属于向左移动覆盖
                newArray[i] = oldArray[i + 1];
            }
        }
        return newArray; // 将新数组返回
    }

}
