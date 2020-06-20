package com.waibizi.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Author 歪鼻子
 * @Date 2020/6/19 16:49
 * @Description:
 * @Version 1.0
 */
public class NIOClient2 {
    public static void main(String[] args) throws IOException {
        //得到一个网络通道
        SocketChannel channel = SocketChannel.open();
        //设置为非阻塞
        channel.configureBlocking(false);
        //提供服务器端的ip和端口
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",6666);
        //连接服务器
        if (!channel.connect(inetSocketAddress)){
            while (!channel.finishConnect()){
                System.out.println("客户端可以边连接边进行其他的操作");
            }
        }
        //如果连接成功，就开始发送数据
        String msg = "歪鼻子已就位!";
        //将发送数据以字节的形式写入到buffer当中
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
        //将buffer写入到channel当中
        channel.write(buffer);
        System.in.read();
    }
}
