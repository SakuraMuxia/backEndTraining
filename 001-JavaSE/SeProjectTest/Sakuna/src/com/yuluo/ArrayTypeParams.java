package com.yuluo;

import java.util.Scanner;

public class ArrayTypeParams {
    public static void main(String[] args) {
        // 统计成绩
        double[] scoreArr = score();
        // 打印成绩
        scorePrint(scoreArr);
    }
    // 统计学生5门成绩并且返回
    public static double[] score(){
        Scanner input = new Scanner(System.in);
        double [] scoreArr = new double[5];
        for (int i = 0; i < scoreArr.length; i++) {
            System.out.println("请输入第"+(i+1)+"门成绩");
            // 输入成绩
            scoreArr[i] = input.nextDouble();
        }
        return scoreArr;
    }
    // 打印学生5门成绩
    public static void scorePrint(double[] scoreArr){
        for (int i = 0; i < scoreArr.length; i++) {
            System.out.println("第"+(i+1)+"门成绩为"+scoreArr[i]);
        }
    }
}
