package com.wei.rtsp.decoder;

import com.sun.org.slf4j.internal.LoggerFactory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.HttpContent;
import jdk.nashorn.internal.runtime.logging.Logger;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Logger
public class RTSPDecoder extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive:"+ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof DefaultHttpRequest){
            System.out.println();
        }else if(msg instanceof HttpContent){
            System.out.println();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
