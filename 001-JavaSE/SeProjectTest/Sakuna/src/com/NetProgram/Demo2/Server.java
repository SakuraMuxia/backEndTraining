package com.NetProgram.Demo2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        // 创建Socket
        try {
            ServerSocket server = new ServerSocket(9090);
            System.out.println("服务器已启动");
            // 一直运行
            while(true){
                Socket socket = server.accept();
                // 每一个socket，开启一个线程
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
