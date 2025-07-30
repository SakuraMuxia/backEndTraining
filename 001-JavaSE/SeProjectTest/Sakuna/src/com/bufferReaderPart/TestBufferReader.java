package com.bufferReaderPart;

import java.io.*;

public class TestBufferReader {
    public static void main(String[] args) {
        // 生命字节流对象
        FileInputStream inputStream = null;
        // 声明字符流对象\转化流
        InputStreamReader inputStreamReader = null;
        // 声明缓冲流对象
        BufferedReader reader = null;

        // 异常处理
        try {
            // 创建字节流读对象
            inputStream = new FileInputStream("D:\\Test.txt");
            // 创建字符流读对象(承上启下作用 又称为转换流)
            inputStreamReader = new InputStreamReader(inputStream);
            // 创建缓冲流对象
            reader = new BufferedReader(inputStreamReader);
            // 声明读取内容返回值 因为每次读取一行 所以返回值为String类型
            String line = null;
            // 读取文件,遍历文件
            while( (line = reader.readLine()) != null){
                // 打印读取内容
                System.out.println(line);
            }
        } catch (IOException e) {
            // 打印堆栈信息
            e.printStackTrace();
        }finally {
            // 关闭之前做非空判断
            try {
                if (reader != null) {
                    reader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
