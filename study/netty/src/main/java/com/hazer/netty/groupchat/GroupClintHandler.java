package com.hazer.netty.groupchat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.format.DateTimeFormatter;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-07-06 22:15
 */
public class GroupClintHandler extends SimpleChannelInboundHandler {
    //代替simpleDateFormat
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(msg.toString().trim());
    }
}
