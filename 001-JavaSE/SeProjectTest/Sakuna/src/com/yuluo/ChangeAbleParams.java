package com.yuluo;

public class ChangeAbleParams {
    // 可变长参数
    public static void funChangeParams (int ... args) {
        System.out.println("fun方法执行");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }

    // 数组类型的参数
    public static void funArrayTypeParams(int [] args){
        System.out.println("funArray方法执行");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
    public static void main(String[] args) {
        // 一个方法调用
        funChangeParams(12,13,14,15);
        // 第二个方法调用
        int [] nums = {13,14,15,16};
        funArrayTypeParams(nums);
    }
}
