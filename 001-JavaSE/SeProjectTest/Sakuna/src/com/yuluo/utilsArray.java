package com.yuluo;

import java.util.Arrays;

public class utilsArray {
    public static void main(String[] args) {
        int [] nums = {56,12,22,41,85,99};
        // 使用 sort方法排序：快速排序 默认是升序
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums)); // [12, 22, 41, 56, 85, 99]

        int [] newArr = new int[nums.length];
        // 降序排序
        for (int i = 0,j = nums.length -1; i < nums.length; i++,j--) {
            newArr[i] = nums[j];
        }
        System.out.println(Arrays.toString(newArr)); // [99, 85, 56, 41, 22, 12]
        // 填充元素
        Arrays.fill(newArr,445);
        System.out.println(Arrays.toString(newArr)); // [445, 445, 445, 445, 445, 445]

        // 查找元素
        int index = Arrays.binarySearch(nums, 41);
        System.out.println("查找到的下标为"+index); // 查找到的下标为 2
    }
}
