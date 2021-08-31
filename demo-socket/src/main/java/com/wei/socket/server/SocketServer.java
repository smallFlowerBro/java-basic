package com.wei.socket.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class SocketServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8089);
            while(true){
                System.out.println("服务监听中");
                Socket socket = serverSocket.accept();
                InetAddress inetAddress = socket.getInetAddress();
                System.out.println("当前请求地址:"+inetAddress.getHostAddress());
                new Thread(new ServerThread(socket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
