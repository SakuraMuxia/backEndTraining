package com.inputStreamPart;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestInputStreamReader {
    public static void main(String[] args){
        // 初始化 文件输入流对象
        FileInputStream fileInputStream = null;
        // 初始化 字符读取流对象
        InputStreamReader inputStreamReader = null;

        try {
            // 创建对象
            fileInputStream = new FileInputStream("D:\\Text file.txt");
            inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
            // 获取文件可读字节长度
            int availableNum = fileInputStream.available();
            // 每次读取一个字符数组
            char [] data = new char[availableNum]; // 一次读完
            // 初始化 读取到内容的长度
            int readedLength = -1;
            // 遍历读取
            while ((readedLength = inputStreamReader.read(data)) != -1){
                // 方式1：直接使用 println方法中默认对char数组的遍历方法
                // System.out.println(data);
                // 方式2：使用String类中的构造方法，将char数组转为String类型
                String strFragment = new String(data, 0, readedLength);
                System.out.println(strFragment);// 字符片段，每5个字符遍历一次打印一行

            }
        }catch (IOException e){
            // 捕获异常
            e.printStackTrace();
        }  finally {
            // 关闭资源
            try{
                // 在关闭之前做非空判断 因为如果为空 调用close方法 将出现空指针异常
                if(inputStreamReader != null){
                    inputStreamReader.close();
                }
                if(fileInputStream != null){
                    fileInputStream.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
