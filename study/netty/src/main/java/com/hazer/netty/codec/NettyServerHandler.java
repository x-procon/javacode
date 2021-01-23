package com.hazer.netty.codec;

import com.hazer.netty.protobuf.StudentPojo;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @description: 自定义handler需要继承netty内置得HandlerAdapter，这样之自定义得handler才能生效
 *
 * @author: Hazer
 * @date: 2020-07-03 17:23
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    /**
     * @description: 读取客户端发送得消息
     * @param: [ctx, msg]
     * @return: void
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        StudentPojo.Student student = (StudentPojo.Student) msg;
        System.out.println("客户端发送的数据："+student.getName()+"--"+student.getId());
    }

    /**
     * @description: 数据读取完毕得操作
     * @param: [ctx]
     * @return: void
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //将数据写到缓冲区并刷新
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello 客户端",CharsetUtil.UTF_8));
    }

    /**
     * @description: 处理异常关闭通道
     * @param: [ctx, cause]
     * @return: void
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
