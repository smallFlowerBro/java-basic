package com.wei.netty;

import com.wei.netty.server.DemoServer;
import com.wei.netty.server.HttpServer;
import com.wei.netty.server.NettyServer;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class NettyServerApplication {

    public static void main(String[] args) {
        NettyServer server=new HttpServer();
        try {
            server.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
