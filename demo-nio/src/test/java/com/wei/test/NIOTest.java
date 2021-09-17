package com.wei.test;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */

public class NIOTest {

    String fileName="C:\\Users\\weiyongjian\\Desktop\\test.txt";
    String fileName2="C:\\Users\\weiyongjian\\Desktop\\test2.txt";

    @Test
    public void test1() throws IOException {
        RandomAccessFile file = new RandomAccessFile(fileName, "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int read;
        while((read=channel.read(buffer))!=-1){
            System.out.println("read:"+read);
            buffer.flip();
            while(buffer.hasRemaining()){
                System.out.print((char)buffer.get());
            }
            buffer.clear();
        }
        file.close();
    }


    @Test
    public  void test2() throws IOException {
        FileChannel channel1 = new RandomAccessFile(fileName, "rw").getChannel();
        FileChannel channel2 = new RandomAccessFile(fileName2, "rw").getChannel();

        long position =0;
        long count = channel2.size();

        channel1.transferFrom(channel2,position,count);



    }
    @Test
    public void test3() throws IOException {
        FileChannel channel1 = new RandomAccessFile(fileName, "rw").getChannel();
        channel1.truncate(64);

    }
    @Test
    public void test4() throws IOException {
        SocketChannel socket = SocketChannel.open();
        socket.connect(new InetSocketAddress("127.0.0.1",8080));
        ByteBuffer buf = ByteBuffer.allocate(512);
        socket.write(buf);
        int a;
        while((a=socket.read(buf))!=-1){
            buf.flip();
            while(buf.hasRemaining()){
                System.out.print((char)buf.get());
            }
            buf.clear();
        }
        socket.close();

    }

}
