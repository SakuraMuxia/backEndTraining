package com.fireWritePart;

import java.io.*;

public class TestFileWrite {
    public static void main(String[] args) {
        // 声明文件对象
        File file = null;
        // 声明字符写入流对象
        FileWriter fileWriter = null;


        try {
            // 创建文件对象
            file = new File("D:\\Test.txt");
            // 创建字符写入流对象
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
