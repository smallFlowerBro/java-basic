package com.wei.netty.server;

import com.wei.netty.server.handler.HttpServerHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class HttpServer implements NettyServer{
    /*监听端口*/
    private int port=8080;

    @Override
    public void run() throws InterruptedException {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss,work)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast("http-decode",new HttpRequestDecoder())
                                    .addLast("http-encode",new HttpResponseEncoder())
                                    .addLast("http-service",new HttpServerHandler());
                        }
                    });
            ChannelFuture sync = bootstrap.bind(port).sync();
            System.out.println("服务已启动，端口:"+port);
            sync.channel().closeFuture().sync();
        }finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }


    }
}
