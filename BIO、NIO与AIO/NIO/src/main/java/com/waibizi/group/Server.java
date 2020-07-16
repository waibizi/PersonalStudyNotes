package com.waibizi.group;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @Author 歪鼻子
 * @Date 2020/7/9 14:56
 * @Description: 群聊天，服务端
 * @Version 1.0
 */
public class Server {
    /* 定义属性 */
    private Selector selector = null;
    private ServerSocketChannel listenChannel = null;
    private static final int PORT = 2048;

    /**
     * 初始化服务端
     * @throws IOException
     */
    public Server() throws IOException {
        /* 打开选择器 */
        selector = Selector.open();
        /* 打开通道 */
        listenChannel = ServerSocketChannel.open();
        /* 绑定端口 */
        listenChannel.socket().bind(new InetSocketAddress(PORT));
        /* 设置为非阻塞状态 */
        listenChannel.configureBlocking(false);
        /* 将通道注册到选择器当中（注意：注册的状态应该是接受的状态） */
        listenChannel.register(selector, SelectionKey.OP_ACCEPT);
    }
    public void listen() throws IOException {
        while (true) {
            /* 如果选择器有事件需要处理，也就是选择器的选择大于0 */
            if (selector.select()>0){
                /* 遍历得到所有的selectedKey（每个Channel向Selector注册时,都将会创建一个selectionKey） */
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    /* 取出selectionKey */
                    SelectionKey key = iterator.next();
                    /* 监听到key的状态为accept */
                    if (key.isAcceptable()) {
                        SocketChannel sc = listenChannel.accept();
                        /* 将通道收到的socketChannel设置为非阻塞状态 */
                        sc.configureBlocking(false);
                        /* 将该socketChannel注册到selector并设置为状态read */
                        sc.register(selector,SelectionKey.OP_READ);
                        System.out.println("地址是"+sc.getRemoteAddress().toString().substring(1)+"的用户上线了");
                    }
                    /* 如果通道是read事件，即通道是可读状态 */
                    if (key.isReadable()){
                        read(key);
                    }
                    /* 移除已经处理过的selectionKey */
                    iterator.remove();
                }
            }
        }
    }
    /**
     * 根据key读取消息
     * @param key
     */
    private void read(SelectionKey key){
        SocketChannel channel = null;
        /* 得到Key当中的channel */
        channel = (SocketChannel) key.channel();
        /* 创建缓冲区 */
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        /* 如果读取到数据 */
        try {
            if (channel.read(buffer)>0){
                /* 把缓冲区的数据转成字符串 */
                String msg = new String(buffer.array());
                System.out.println("来自客户端的消息："+msg.trim());
                /* 向除了自己的其他客户端转发消息 */
                sendInformationToOther(msg,channel);
            }
        }catch (IOException e){
            try {
                System.out.println(channel.getRemoteAddress() + " 离线了..");
                /* 取消注册 */
                key.cancel();
                /* 关闭通道 */
                channel.close();
            }catch (IOException ee){
                ee.printStackTrace();
            }
        }
    }
    private void sendInformationToOther(String msg,SocketChannel self) throws IOException {
        System.out.println("服务器转发消息中······");
        /* 遍历所有注册到选择器的Socket并且排除自己 */
        for (SelectionKey key:selector.keys()){
            /* 通过key取出channel */
            Channel target = key.channel();
            if (target instanceof SocketChannel && target != self){
                SocketChannel dest = (SocketChannel)target;
                /* 将msg存储到buffer */
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                /* 将buffer的数据写入到通道当中 */
                dest.write(buffer);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.listen();
    }
}
