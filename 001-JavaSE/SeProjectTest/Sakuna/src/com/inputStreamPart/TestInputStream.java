package com.inputStreamPart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestInputStream {
    public static void main(String[] args) throws IOException {
        // 创建文件对象
        File file1 = new File("D:\\Text file.txt");
        // 创建文件读取流对象
        FileInputStream inputStream = null;

        try{
            // 创建输入流对象
            inputStream = new FileInputStream(file1);
            // 调用 available 方法获取可读内容长度
            int availableNum = inputStream.available();
            System.out.println("获取可读取内容长度： " + availableNum);
            // 创建字节数组，长度是获取到的可读内容长度
            byte[] data = new byte[availableNum];
            // 初始化已读取的内容长度
            int readedLength = -1;
            // 循环遍历
            while((readedLength = inputStream.read(data)) != -1){ // 当读取到文件内容的末尾时，返回值为-1
                // 使用String类中的构造方法将 字节数组转为 String类型
                // 第一个参数 byte数组,第二个参数 从0开始转换,第三个参数 转换的数量(即读取到几个 就转换几个字节)
                System.out.println("已读取内容长度：" + readedLength);
                String readedContent = new String(data,0,readedLength);
                System.out.println("读取到的内容：" + readedContent); // 打印每次读取到的内容
            }

        }catch (IOException e){
            // 打印异常堆栈信息
            e.printStackTrace();
        }finally {
            // 关闭资源
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
