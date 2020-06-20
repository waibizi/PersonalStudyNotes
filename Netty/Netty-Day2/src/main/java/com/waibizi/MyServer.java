package com.waibizi;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author 歪鼻子
 * @Date 2020/6/18 1:49
 * @Description:
 * @Version 1.0
 */
public class MyServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup master = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(master,worker).channel(NioServerSocketChannel.class).childHandler(null);
            ChannelFuture channelFuture = serverBootstrap.bind(2048).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            master.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

}
