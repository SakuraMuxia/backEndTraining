package com.NetProgram.Demo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try {
            // 创建服务器端Socket对象 端口号为 8899
            ServerSocket server = new ServerSocket(8899);
            System.out.println("服务器已启动");
            // 接收客户端请求 获取到Socket对象
            // accept()方法会等待用户发送请求 然后再继续向下执行
            Socket socket = server.accept();
            // 根据Socket对象获取字节读取流
            InputStream inputStream = socket.getInputStream();
            // 根据字节读取流创建 BufferedReader对象
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            // 读取对象
            System.out.println("接收到客户端信息：" + reader.readLine());

            // 发送信息
            OutputStream outputStream = socket.getOutputStream();
            String msg = "你好，客户端";
            outputStream.write(msg.getBytes());
            // 关闭流
            socket.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
