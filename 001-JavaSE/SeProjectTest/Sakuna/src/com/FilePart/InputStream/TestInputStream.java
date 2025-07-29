package com.FilePart.InputStream;

import java.io.File;
import java.io.IOException;

public class TestInputStream {
    public static void main(String[] args) throws IOException {
        // 创建File对象
        File file1 = new File("D:\\fileTest.txt");
        File file2 = new File("D:\\fileTest2.txt");
        // 文件是否存在
        boolean exists = file1.exists();
        System.out.println("文件是否存在 " + exists); // true

        // 文件是否是文件形式
        boolean file = file1.isFile();
        System.out.println("是否是文件格式 " + file); // true

        // 是否是目录格式
        boolean directory = file1.isDirectory();
        System.out.println("是否是目录格式 " + directory); // false

        // 返回文件对象的绝对目录
        String path = file1.getAbsolutePath();
        System.out.println("文件对象的绝对路径 " + path); // D:\fileTest.txt

        // 获取对象的文件名
        String name = file1.getName();
        System.out.println("文件名 " + name); // fileTest.txt

        // 创建文件
        boolean newFile = file2.createNewFile();
        long length = file2.length();
        System.out.println("文件的长度为 " + length); // 18
        System.out.println("文件是否成功创建 " + newFile); // 文件是否成功创建 true
    }
}
