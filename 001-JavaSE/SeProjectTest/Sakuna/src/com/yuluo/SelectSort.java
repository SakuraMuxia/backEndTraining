package com.yuluo;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {-2, 562, -1, 451, 110, 23, 45, 85, 96, 666};
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) { // A
            int index = i; // 定义moveIndex 表示为需要最终交换位置的下标
            for (int j = i + 1; j < length; j++) { // B
                if (nums[index] > nums[j]) {
                    // 如果A > B,把J的下标赋值给index,拿着B去找下一个B比较,直到这一轮比较结束
                    index = j;
                }
            }
            // 如果moveIndex 和 i的值不相同 则表示需要交换元素
            // 因为 只有比较大小的条件成立 moveIndex的值 才会发生变化
            // 而条件成立 则表示有需要交换位置的元素
            // 最终将moveIndex 和 i 对应位置的元素进行交换 因为
            // i 表示每一轮的第一个元素 而moveIndex最终将停留在最大/最小的元素
            if (index != i) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                count++;
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println("一共交换了" + count + "次位置");
    }
}
