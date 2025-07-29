package com.inputStreamPart;

import java.io.FileOutputStream;
import java.io.IOException;

public class TestOutputStream {
    public static void main(String[] args) throws IOException {
        // 创建文件输入流对象
        FileOutputStream outputStream = new FileOutputStream("D:\\Text file1.txt",true);

        // 创建字符传
        String str = "争渡，争渡，惊起一滩鸥鹭";
        // 调用 字符串实例的 getBytes方法 将字符串转为 字节数组
        byte[] data = str.getBytes();
        // 写入
        outputStream.write(data);
        // 关闭流
        outputStream.close();
    }
}
