package com.wei.socket.client;

import java.io.*;
import java.net.Socket;
/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class SocketClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8090);
            InputStream inputStream =socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream));
            printWriter.println("你好服务器");
            printWriter.flush();
            socket.shutdownOutput();
            String s = bufferedReader.readLine();
            System.out.println("收到服务器回复:"+s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
