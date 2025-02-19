package com.yuluo;

public class ForTest {
    public static void main(String[] args) {
        for(int i=1;i <=5;i++){ // 外层循环 控制行数
            // 左半部分
            for(int j = 5; j >= i;j--){
                System.out.print(" ");
            }
            // 右半部分
            for(int j = 1;j <= (2 * i -1);j++){
                System.out.print("*");
            }
            // 换行
            System.out.println();
        }
    }
}
