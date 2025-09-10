package com.NetProgram.Demo2;

import java.io.*;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) {
        // 创建 Socket对象
        try {
            Socket socket = new Socket("127.0.0.1",9090);
            // 获取一个写入流对象
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("你好，服务器".getBytes());
            // 关闭写入流
            socket.shutdownOutput();

            // 读取流
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            // 打印数据
            System.out.println("服务器回复：" + reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
