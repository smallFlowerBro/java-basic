package com.wei.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class TestDemo {

    @Test
    public void test1(){
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);
            serverSocketChannel.socket().bind(inetSocketAddress);

            ByteBuffer byteBuffer = ByteBuffer.allocate(8);

            SocketChannel socketChannel= serverSocketChannel.accept();

            socketChannel.read(byteBuffer);
            System.out.println(byteBuffer);
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
