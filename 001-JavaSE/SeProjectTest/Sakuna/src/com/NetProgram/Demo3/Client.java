package com.NetProgram.Demo3;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        // 准备数据
        String msg = "你好,服务器";
        byte[] sendData = msg.getBytes();
        try {
            // 获取地址对象 使用InetAddress类静态方法
            InetAddress localhost = InetAddress.getByName("127.0.0.1");
            // 准备数据包
            DatagramPacket packet = new DatagramPacket(sendData,sendData.length,localhost,12455);
            // 准备DatagramPacket对象
            DatagramSocket socket = new DatagramSocket();
            // 发送数据
            socket.send(packet);
            // 客户端接收数据
            // 准备数组接收数据
            byte[] receiveData = new byte[36];
            // 准备数据包对象
            DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
            // 接收数据
            socket.receive(receivePacket);
            // 调用方法获取 获取接收到的数据
            byte[] data = receivePacket.getData();
            // 解析数据
            String res = new String(data,0,data.length);
            System.out.println(res);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
