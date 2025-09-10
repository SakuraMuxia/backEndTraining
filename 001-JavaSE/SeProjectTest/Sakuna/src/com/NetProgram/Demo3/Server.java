package com.NetProgram.Demo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) {

        try {
            // 创建Socket对象
            DatagramSocket socket = new DatagramSocket(12455);
            System.out.println("服务已启动");
            // 准备数组接收数据
            byte[] receiveData = new byte[36];
            // 准备数据包对象
            DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
            // 接收数据
            socket.receive(receivePacket);
            // 调用方法获取 获取接收到的数据
            byte[] data = receivePacket.getData();
            // 获取客户端的IP信息
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            // 解析数据
            String msg = new String(data,0,data.length);
            System.out.println(msg);
            // 发送数据
            byte[] sendData = "你好，客户端".getBytes();
            // 准备数据包
            DatagramPacket packet = new DatagramPacket(sendData, sendData.length,clientAddress,clientPort);
            socket.send(packet);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
