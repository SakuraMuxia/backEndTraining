package com.outputStreamWrite;

import java.io.*;

public class TestOutputStreamWriter2 {
    public static void main(String[] args) {
        // 打印本地平台默认的编码格式
        System.out.println(System.getProperty("file.encoding")); // UTF-8
        // 创建字节流写入对象 如果文件不存在将自动创建
        FileOutputStream fileOutputStream = null;
        // 声明字符流写入对象
        OutputStreamWriter outputStreamWriter = null;
        // 创建字节流读对象
        FileInputStream fileInputStream = null;
        // 创建字符读取流对象
        InputStreamReader inputStreamReader = null;
        // 创建字符读取流缓存对象
        BufferedReader bufferedReader = null;

        try {
            // 创建字节流对象
            fileOutputStream = new FileOutputStream("D:\\test.txt");
            // 创建字符写入流对象
            outputStreamWriter = new OutputStreamWriter(fileOutputStream,"GBK");
            // 调用方法-写入
            outputStreamWriter.write("happy,世界");
            // 刷新缓存
            outputStreamWriter.flush();

            // -------------------------
            // 创建字节读取对象
            fileInputStream = new FileInputStream("D:\\test.txt");
            // 创建字符读取流对象
            // 因为写入的编码格式为 GBK 所以读取的编码格式也应该设置为  GBK 否则将出现乱码
            inputStreamReader = new InputStreamReader(fileInputStream,"GBK");
            // 创建字符读取流缓冲对象
            bufferedReader = new BufferedReader(inputStreamReader);
            // 调用读取流对象获取一行数据
            String str = bufferedReader.readLine();
            System.out.println(str);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 关闭资源
            if (outputStreamWriter != null){
                try {
                    // 关闭字符写入流资源
                    outputStreamWriter.close();
                    // 关闭字节写入流资源
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
