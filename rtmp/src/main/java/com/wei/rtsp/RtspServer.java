package com.wei.rtsp;

import com.wei.rtsp.config.HandlerConfig;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class RtspServer {

    public static void main(String[] args) throws InterruptedException {
        new RtspServer().run();
    }

    public void run() throws InterruptedException {
        NioEventLoopGroup boss  = new NioEventLoopGroup();
        NioEventLoopGroup group = new NioEventLoopGroup();
        try{
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss,group)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new HandlerConfig())
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true);
            ChannelFuture sync = bootstrap.bind(7000).sync();
            sync.channel().closeFuture().sync();
        }finally {
            boss.shutdownGracefully();
            group.shutdownGracefully();

        }

    }
}
