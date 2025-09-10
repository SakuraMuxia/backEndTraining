package com.NetProgram.Demo2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ServerThread extends Thread{
    // 定义属性为 套接字 socket
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 服务器运行的代码，多线程
        InputStream inputStream = null;
        try {
            // 获取 读取流对象
            inputStream = socket.getInputStream();
            // 创建带缓存读取流
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            // 获取客户端的信息
            InetAddress clientInetInfo = socket.getInetAddress();
            String hostName = clientInetInfo.getHostName();
            String hostAddress = clientInetInfo.getHostAddress();
            // 打印信息
            System.out.println("hostName: " + hostName + "|" + reader.readLine());

            // 获取写入流
            OutputStream outputStream = socket.getOutputStream();
            // 写入数据
            outputStream.write("我是服务器，我一直在...".getBytes());
            // 关闭写入流
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
