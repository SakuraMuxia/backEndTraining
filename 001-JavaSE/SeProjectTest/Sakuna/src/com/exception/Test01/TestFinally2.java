package com.exception.Test01;

import java.util.Arrays;

public class TestFinally2 {
    //
    public static int m1(){
        int num = 10; // 基本数据类型
        try{
            num++;  // 11
            return num; // 11 这时方法就出栈了,返回内容
        }catch(Exception e){ // 捕获检查型异常
            e.printStackTrace(); // 打印堆栈异常信息
        }finally{
            num++; // 12 由于存在finally关键字,num会加1,但是已经返回了11,不会返回12
            // return num; // 如果这里返回了 num 则这里 最后a的值为12
        }
        return num; // 11 这个语句不会被执行
    }
    public static int[] m2(){
        int [] nums = {1,2,3,4,5};
        try{
            for (int i = 0; i < nums.length; i++) { // 遍历整个数组，每个元素加1
                nums[i]++;
            }
            return nums; // 返回数组地址，地址不会变
        }catch (Exception e){
            // 打印堆栈中的信息
            e.printStackTrace();
        }finally {
            for (int i = 0; i < nums.length; i++) { // 再次遍历整个数组，每个元素加1
                nums[i]++; // 对数组对象中的内容进行了更改，之前return 的数组地址没有改变，但是内容发生了改变
            }
        }
        // 返回nums 对象
        return nums;
    }
    // 测试类
    public static void main(String[] args) {
        int a = m1(); // 11
        System.out.println(a); // 11

        int [] nums = m2(); // [3,4,5,6,7]
        System.out.println(Arrays.toString(nums)); // [3,4,5,6,7]
    }
}
