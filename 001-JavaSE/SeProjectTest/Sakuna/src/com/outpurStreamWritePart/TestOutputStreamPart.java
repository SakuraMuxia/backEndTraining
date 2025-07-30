package com.outpurStreamWritePart;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TestOutputStreamPart {
    public static void main(String[] args) {
        // 声明字节写入流对象
        FileOutputStream outputStream = null;
        // 声明字符写入流对象
        OutputStreamWriter writer = null;

        try {
            // 创建字节写入流对象
            outputStream = new FileOutputStream("D:\\Test.txt",true);
            // 创建字符写入流对象
            writer = new OutputStreamWriter(outputStream);
            // 调用 write方法
            writer.write("遗憾早已是习惯",0,2);
            // 刷新到硬盘中
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 关闭流
            try {
                if (writer != null) {
                    writer.close();
                }
                if(outputStream != null){
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
