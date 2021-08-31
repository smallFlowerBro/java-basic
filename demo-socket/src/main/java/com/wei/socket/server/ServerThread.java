package com.wei.socket.server;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.*;
import java.net.Socket;

/**
 * @Author weiyongjian
 * @Description //socket处理类
 * @Date
 */

public class ServerThread implements Runnable {

    private Socket socket=null;

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            System.out.println("业务处理中");
            InputStream inputStream = this.socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String s = bufferedReader.readLine();
            System.out.println("接收到客户端消息:"+s);
            OutputStream outputStream = this.socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream));
            printWriter.println("客户机你好");
            printWriter.flush();
            System.out.println("业务处理结束");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
