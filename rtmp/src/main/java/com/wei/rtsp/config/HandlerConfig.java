package com.wei.rtsp.config;

import com.wei.rtsp.decoder.RTSPDecoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.rtsp.RtspDecoder;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class HandlerConfig extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new RtspDecoder())
                                .addLast(new RTSPDecoder());
    }
}
