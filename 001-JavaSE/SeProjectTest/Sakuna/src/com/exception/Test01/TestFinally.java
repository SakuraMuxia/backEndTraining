package com.exception.Test01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *   finally 表示不管是否出现异常 以及 异常是否被捕获 都将执行的代码块
 *    finally不能单独出现 必须结合 try-catch  或者 try
 *    因为finally最终都将执行 所以通常用于执行一些关闭资源的操作 比如 关闭流 关闭数据库连接对象等等
 *
 *    finally不执行的唯一情况：在执行finally之前退出JVM虚拟机
 *
 *    System.exit(int status) : int类型的状态码含义：0表示正常退出 非0表示非正常退出
 */

public class TestFinally {
    public static void main(String[] args) {
        try{
            Scanner in = new Scanner(System.in);
            System.out.print("请输入被除数:");
            int num1 = in.nextInt();
            System.out.print("请输入除数:");
            int num2 = in.nextInt();
            System.out.println(num1+"/"+ num2 +"="+ num1/ num2);
            // 退出虚拟机 System.exit(int status) : int类型的状态码含义：0表示正常退出 非0表示非正常退出
            System.exit(231321);
        }catch (InputMismatchException e){
            e.printStackTrace(); // 打印异常堆栈信息,通过 jdk文档中的 Throwable顶级异常类中的方法找到的
        }finally { // 不管是否出现异常 以及 异常是否被捕获 都将执行的代码块,除非出现 退出虚拟机
            System.out.println("感谢使用本程序！");
        }
    }
}
