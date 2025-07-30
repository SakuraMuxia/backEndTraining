package com.FileReaderPart;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestFileReader {
    public static void main(String[] args) {
        // 定义FileReader对象
        FileReader reader = null;
        try{
            // 在当前目录下，创建文件
            reader = new FileReader("D:\\Test.txt");
            // 创建长度为10的char数组 用于保存读取数据
            char [] data = new char[80];
            // 定义每次读取字符的个数 初始化值为-1
            int readCount = -1;
            // 循环读取 循环条件为 读取字符个数不为-1
            while((readCount = reader.read(data)) != -1){
                // 将读取完毕的字符数组 转换为字符串
                // 第一个参数 为字符数组
                // 第二个参数 转换为字符串的起始位置
                // 第三个参数 转换个数
                System.out.println(new String(data,0,readCount));
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (reader != null){
                // 关闭流
                try {
                    reader.close();
                } catch (IOException e) {
                    // throw new RuntimeException(e); // 会中断程序
                    e.printStackTrace(); // 不会中断程序
                }
            }

        }
    }
}
