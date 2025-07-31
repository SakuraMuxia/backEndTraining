package com.outputStreamWrite;

import java.io.*;

public class TestBufferWriter {
    public static void main(String[] args) throws IOException {
        // 创建对象 以匿名对象的方法作为参数构造实例
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\test1.txt");
        // 创建字符写入流对象
        OutputStreamWriter outPutStreamWriter = new OutputStreamWriter(fileOutputStream);
        // 创建字符写入流缓存对象
        BufferedWriter bufferWriter = new BufferedWriter(outPutStreamWriter);
        // 写入文件 \n 和newline() 方法都可以实现换行的效果
        bufferWriter.write("yuluochenxiao \n 世界你好");
        bufferWriter.newLine();// 换行
        bufferWriter.write("yuluochenxiao \n 世界你好");
        bufferWriter.flush();// 刷新缓存
        bufferWriter.close(); // 关闭资源
    }
}
