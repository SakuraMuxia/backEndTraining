package com.yuluo;

public class twoDimeArray {
    public static void main(String[] args) {
        // 定义一维数组
        int [] arr1 = {1,2,3,4,5};
        // 定义二维数组
        int [][] arr2 = {{1,2,4},{16,17,18}};
        // 打印二维数组中内层
        System.out.println(arr2[0]); // [I@4554617c
        System.out.println(arr2[0][2]); // 4
        //
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]); // 全部是内存地址
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + "\t"); // 1	2	4
            }
            System.out.println();
        }

    }
}
