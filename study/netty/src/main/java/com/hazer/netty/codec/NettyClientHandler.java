package com.hazer.netty.codec;

import com.hazer.netty.protobuf.StudentPojo;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-07-03 17:47
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    /**
     * @description: 通道准备好时触发
     * @param: [ctx]
     * @return: void
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        StudentPojo.Student.Builder builder = StudentPojo.Student.newBuilder();
        builder.setId(22);
        builder.setName("做爱");
        StudentPojo.Student build = builder.build();
        ctx.writeAndFlush(build);
    }

    /**
     * @description: 当通道有读取时间时触发
     * @param: [ctx, msg]
     * @return: void
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("服务器回复得消息："+byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("服务器得地址:"+ctx.channel().remoteAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
