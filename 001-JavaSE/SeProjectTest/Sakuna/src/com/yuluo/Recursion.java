package com.yuluo;

import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字");
        int val = sc.nextInt();
        int res = getFactor(val);
        System.out.println("结果为" + res);
    }
    public static int getFactor(int num){
        if(num == 1){
            return 1;
        }
        return num * getFactor(num - 1);
    }
}
