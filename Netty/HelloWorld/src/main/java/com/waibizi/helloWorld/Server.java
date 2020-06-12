package com.waibizi.helloWorld;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author 歪鼻子
 * @Date 2020/6/12 23:53
 * @Description:
 * @Version 1.0
 */
public class Server {
    public static void main(String[] args) throws InterruptedException {
        //定义两个事件循环组，一个master、一个worker; master负责连接，worker负责处理数据
        EventLoopGroup master = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(master,worker).channel(NioServerSocketChannel.class).childHandler(new ServerInitializer());
            ChannelFuture channelFuture = serverBootstrap.bind(2048).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            master.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}
