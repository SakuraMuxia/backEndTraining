package com.exception.Test01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * try-catch
 * try 代码块中存放可能会出现异常的代码
 * catch用于捕获异常
 * try或者catch均不能单独使用 try必须结合catch或者catch-finally 或者 finally
 *
 * 情况1 ：
 * 使用单个catch捕获异常 如果出现的异常和捕获的异常类型匹配 则可以正常捕获
 * 使得程序可以顺利执行完毕 如果出现的异常和捕获的异常类型不匹配 则程序将依然中断
 *
 */
public class TestTryCatch {
    public static void main(String[] args) {
        try{
            Scanner in = new Scanner(System.in);
            System.out.print("请输入被除数:");
            int num1 = in.nextInt();
            System.out.print("请输入除数:");
            int num2 = in.nextInt();
            System.out.println(num1+"/"+ num2 +"="+ num1/ num2);
        }catch(InputMismatchException e){ // 捕获输入不匹配类型的异常
            e.printStackTrace(); // 打印异常堆栈信息
        }
        System.out.println("感谢使用本程序！"); // 捕获到了匹配的异常可以正常运行
    }
}
