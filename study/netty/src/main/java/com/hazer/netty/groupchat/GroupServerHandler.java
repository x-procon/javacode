package com.hazer.netty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-07-06 21:38
 */
public class GroupServerHandler extends SimpleChannelInboundHandler<String> {
    //代替simpleDateFormat
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    /**
     * 一旦连接第一个执行
     * @param: [ctx]
     * @return: void
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush(dtf.format(LocalDateTime.now())+":[用户]"+
                channel.remoteAddress()+"加入了聊天！\n");
        channelGroup.add(channel);
    }

    /**
     * @description:
     * @param: [ctx]
     * @return: void
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush(dtf.format(LocalDateTime.now())+":[用户]"+
                channel.remoteAddress()+"上线了！\n");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush(dtf.format(LocalDateTime.now())+":[用户]"+
                channel.remoteAddress()+"下线了！\n");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush(dtf.format(LocalDateTime.now())+":[用户]"+
                channel.remoteAddress()+"离开了！\n");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel ch = ctx.channel();
        channelGroup.forEach(channel -> {
            if( ch != channel){
                channel.writeAndFlush(dtf.format(LocalDateTime.now())+":[用户]"+
                        ch.remoteAddress()+"发送了消息："+msg+"\n");
            }else {
                ch.writeAndFlush(dtf.format(LocalDateTime.now())+":[自己]"+
                        ch.remoteAddress()+"发送了消息："+msg+"\n");
            }
        });
    }
}
