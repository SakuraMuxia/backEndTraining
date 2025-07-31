package com.outputStreamWrite;

import java.io.*;

public class TestObjectInputStream {
    public static void main(String[] args) {
        // 创建Student类对象
        Student stu1 = new Student("Sakuna",24);
        Student stu2 = new Student("Aqua",24);
        Student stu3 = new Student("Yousa",24);

        // 创建字节写入流对象
        FileOutputStream fileOutputStream = null;
        // 创建序列化对象
        ObjectOutputStream objectOutputStream = null;

        // 创建读取流对象
        FileInputStream fileInputStream = null;
        // 创建反序列化对象
        ObjectInputStream objectInputStream = null;

        try {
            // 创建对象
            fileOutputStream = new FileOutputStream("D:\\Student.txt");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            // 写入对象
            objectOutputStream.writeObject(stu1);
            objectOutputStream.writeObject(stu2);
            objectOutputStream.writeObject(stu3);
            objectOutputStream.flush();
            // 关闭流
            objectOutputStream.close();

            // 创建对象
            fileInputStream = new FileInputStream("D:\\Student.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            // 调用方法
            // Object obj1 = objectInputStream.readObject();
            // System.out.println(obj1); // Student{name='Sakuna', age=24}
            Object obj1 = objectInputStream.readObject();
            // 使用强制类型转换
            if (obj1 instanceof Student){
                // 强制类型转换
                Student stu = (Student) obj1;
                System.out.println(stu.getName());
                System.out.println(stu.getAge());
            }
            // 遍历对象
            // 判断可读字节数 大于0 表示文件中还有内容 继续读取
            while(fileInputStream.available() > 0){
                Object o = objectInputStream.readObject(); // 每次读取一个对象
                System.out.println("o = " + o); // 打印
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
