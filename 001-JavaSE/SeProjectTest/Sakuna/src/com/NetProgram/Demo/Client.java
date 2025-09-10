package com.NetProgram.Demo;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        try {
            // 创建客户端Socket对象 指定主机地址为本机 端口号为8899
            Socket socket = new Socket("127.0.0.1",8899);
            // 根据Socket对象获取到字节输出流
            OutputStream outputStream = socket.getOutputStream();
            String message = "你好，服务器";
            // 写入信息
            outputStream.write(message.getBytes());
            // 关闭写入流
            socket.shutdownOutput();

            // 读取数据
            InputStream inputStream = socket.getInputStream();
            // 创建带缓存读取流
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            // 打印
            System.out.println("服务器回复：" + reader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
