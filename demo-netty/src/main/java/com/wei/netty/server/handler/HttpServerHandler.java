package com.wei.netty.server.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class HttpServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("接收到报文");
        FullHttpResponse httpResponse= new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
        httpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/html;charset=UTF-8");
        httpResponse.content().writeBytes("Hello netty".getBytes());
//        ctx.writeAndFlush(httpResponse).addListener(ChannelFutureListener.CLOSE);
        ctx.writeAndFlush(httpResponse).addListener(ChannelFutureListener.CLOSE);
    }

}
