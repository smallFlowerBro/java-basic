package com.wei.netty.server;

import com.wei.netty.server.handler.DemoServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class DemoServer  implements  NettyServer{

    @Override
    public  void run() throws InterruptedException {
        EventLoopGroup boss=  new NioEventLoopGroup();
        EventLoopGroup work=  new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap =new ServerBootstrap();
            bootstrap.group(boss, work)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new DemoServerHandler());
                        }
                    });
            ChannelFuture channel = bootstrap.bind(8080).sync();
            channel.channel().closeFuture().sync();
        }finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }

    }
}
