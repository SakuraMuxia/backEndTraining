package com.exception.Test01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 使用多个catch 块来捕获异常 按照书写顺序 从前往后匹配 只匹配第一个相符的异常.然后就退出try-catch结构
 *
 */
public class TestTryCatch2 {
    public static void main(String[] args) {
        try{
            Scanner in = new Scanner(System.in);
            System.out.print("请输入被除数:");
            int num1 = in.nextInt();
            System.out.print("请输入除数:");
            int num2 = in.nextInt();
            System.out.println(num1+"/"+ num2 +"="+ num1/ num2);
        } catch(InputMismatchException e){ // 捕获输入不匹配异常
            System.err.println("出现了输入不匹配异常"); //  e.printStackTrace();
        } catch(ArithmeticException e){ // 捕获被除数为0的异常
            System.err.println(e.getMessage()); // 获取 异常message信息
            e.printStackTrace();//System.err.println("出现了算数运算异常");//
        }catch(Exception e){ // 捕获顶层异常
            e.printStackTrace();
        }

        System.out.println("感谢使用本程序！");
    }
}
