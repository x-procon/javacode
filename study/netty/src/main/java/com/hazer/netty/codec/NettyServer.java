package com.hazer.netty.codec;

import com.hazer.netty.protobuf.StudentPojo;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-07-03 17:02
 */
public class NettyServer {
    public static void main(String[] args){
        //bossGroup 指处理链接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        //创建服务器端启动得对象，可以配置启动参数
        //channel ->pipeline -> handler
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup,workGroup)      //设置两个线程组
                     .channel(NioServerSocketChannel.class)     //说明服务器端使用得channel类型
                     .option(ChannelOption.SO_BACKLOG,128)  //设置线程队列得到得连接个数
                     .childOption(ChannelOption.SO_KEEPALIVE,true) // 设置保持连接得状态
                     .childHandler(new ChannelInitializer<SocketChannel>() {
                         //给pipeline设置处理器在最后
                         @Override
                         protected void initChannel(SocketChannel ch) throws Exception {
                             ch.pipeline().addLast("decoder",new ProtobufDecoder(StudentPojo.Student.getDefaultInstance()));
                                ch.pipeline().addLast(new NettyServerHandler());
                         }
                     });    //给workgroup 得eventLoop设置处理器
            System.out.println(" 服务器 is ready");
            ChannelFuture cf = bootstrap.bind(6666).sync();

            //对关闭通道进行监听
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}
