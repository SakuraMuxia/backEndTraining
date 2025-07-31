package com.outputStreamWrite;

import java.io.*;

public class TestDataInputStream {
    public static void main(String[] args) {
        // 声明字节读取流对象
        FileInputStream fileInputStream = null;
        // 声明数据流读取流对象
        DataInputStream dataInputStream = null;

        // 声明字节写入流对象
        FileOutputStream fileOutputStream = null;
        // 声明数据写入流对象
        DataOutputStream dataOutputStream = null;
        try {
            // 创建字节读取流对象
            fileInputStream = new FileInputStream("D:\\test.png");
            dataInputStream = new DataInputStream(fileInputStream);

            // 创建字节写入流对象
            fileOutputStream = new FileOutputStream("D:\\test2.png");
            dataOutputStream = new DataOutputStream(fileOutputStream);

            //  定义byte数组 长度为此文件的可读字节数
            byte [] data = new byte[fileInputStream.available()];
            // 读取二进制文件,内容保存在byte数组中
            int read = dataInputStream.read(data);
            System.out.println("read = " + read); // 642452

            // 写入二进制文件
            dataOutputStream.write(data);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 关闭资源
            try {
                dataOutputStream.close();
                fileOutputStream.close();
                dataInputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
