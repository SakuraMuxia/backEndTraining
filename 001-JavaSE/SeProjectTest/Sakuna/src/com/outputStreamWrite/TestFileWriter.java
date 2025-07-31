package com.outputStreamWrite;

import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter {
    public static void main(String[] args) {
        // 声明写入文件对象
        FileWriter writer = null;

        try {
            // 创建对象
            writer = new FileWriter("D:\\test.txt");
            // 写入内容
            writer.write("Helle Yuluo 雨落辰潇");
            // 刷新内容
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 关闭资源
            try {
                if(writer != null){
                    writer.close();
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
