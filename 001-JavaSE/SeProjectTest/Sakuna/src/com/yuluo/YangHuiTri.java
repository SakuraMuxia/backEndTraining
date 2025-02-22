package com.yuluo;

public class YangHuiTri {
    public static void main(String[] args) {
        // 定义一个 6*6 的矩阵
        int [][] yh = new int[6][6];
        // 遍历 赋值
        for (int i = 0; i < yh.length; i++) {
            yh[i][0] = 1; // 每一行的第一列为1
            yh[i][i] = 1; // 每一行的第i列为1
            if(i > 1){ // 表示从第3行开始 赋值有具体的计算
                for (int j = 1; j < i; j++) {
                    yh[i][j] = yh[i-1][j] + yh[i-1][j-1];
                }
            }
        }
        // 遍历 打印
        for(int i = 0;i < yh.length;i++){
            for(int j = 6;j >= i;j--){
                System.out.print(" "); // 打印一个倒三角形
            }
            for(int j = 0;j <= i;j++){  // 打印一个正三角形
                System.out.print(yh[i][j] + " ");
            }
            System.out.println();
        }
    }
}
