package com.wei.netty.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class DemoServerHandler extends ChannelInboundHandlerAdapter {
    /*连接上*/
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty Server is connecting............".getBytes()));

    }

    /*接收到消息*/
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channel read start");
        System.out.println(msg);
        System.out.println("channel read end");
    }

    /*连接抛出异常*/
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ByteBuf buf = Unpooled.copiedBuffer("Server error".getBytes(CharsetUtil.UTF_8));
        ctx.writeAndFlush(buf);
        ctx.close();
    }

//    @Override
//    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        ctx.writeAndFlush(Unpooled.copiedBuffer("channel Read Complete\n".getBytes()));
//    }

}
