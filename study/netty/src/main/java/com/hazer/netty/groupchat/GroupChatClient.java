package com.hazer.netty.groupchat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-07-06 22:01
 */
public class GroupChatClient {
    private final String ip;
    private final int port;

    public GroupChatClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void run(){
        Bootstrap bootstrap = new Bootstrap();
        EventLoopGroup clientGroup = new NioEventLoopGroup();
        try {
            bootstrap.group(clientGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("decode",new StringDecoder())
                                    .addLast("encode",new StringEncoder())
                                    .addLast(new GroupClintHandler());
                        }
                    });
            ChannelFuture channelFuture = bootstrap.connect(ip, port).sync();
            Channel channel = channelFuture.channel();
            System.out.println("-------"+channel.remoteAddress()+"-------");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()){
                String msg = scanner.nextLine();
                channel.writeAndFlush(msg+"\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            clientGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        GroupChatClient groupChatClient = new GroupChatClient("127.0.0.1", 8990);
        groupChatClient.run();
    }
}
