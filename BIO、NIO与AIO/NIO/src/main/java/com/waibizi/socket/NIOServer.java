package com.waibizi.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author 歪鼻子
 * @Date 2020/6/12 18:00
 * @Description:
 * @Version 1.0
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        //创建ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //得到一个Selector
        Selector selector = Selector.open();
        //绑定一个端口666，在服务器端监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        //设置为非阻塞,NIO就是在这个部分可以设置为非阻塞的状态
        serverSocketChannel.configureBlocking(false);
        //把serverSocketChannel注册到selector关联，并将Channel设置为OP_ACCEPT，OP_ACCEPT表示的就是就绪状态
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("注册后的selectionKey的数量 = "+selector.keys().size());
        //循环等待客户端连接
        while (true){
            //这里我们等待1秒，如果没有时间发生，则返回
            if (selector.select(1000) == 0){
                System.out.println("服务器等待了一秒，没有人连接");
                continue;
            }
            //如果返回的大于0，就获取到相关的selectionKey
            //1. 如果返回的>0， 表示已经获取到关注的事件
            //2. selector.selectedKeys() 返回关注事件的集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("SelectionKey的数量 = "+selectionKeys.size());
            //遍历Set<SelectionKey>，使用迭代器遍历
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()){
                //获取到SelectionKey
                SelectionKey key = keyIterator.next();
                //根据key对应的通道发生的事件做相应的处理:如果key的状态是OP_ACCEPT也就是有一个连接请求
                if (key.isAcceptable()){
                    //调用accept这个方法，表示可以进行TCP三次握手了
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端连接成功！生成了一个socketChannel，本地连接的socketChannel的标识码是 = "+socketChannel.hashCode());
                    //将SocketChannel 设置为非阻塞
                    socketChannel.configureBlocking(false);
                    //将socketChannel注册到selector，关注事件为OP_READ,同时给socketChannel
                    //关联到一个Buffer
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    System.out.println("客户端连接了，selectionKey的数量 = "+selector.keys().size());
                }
                //如果key的状态是OP_READ，也就是有数据发送过来了，此时需要读取客户端发送的数据了
                if (key.isReadable()){
                    //通过key反向获取到对应的Channel
                    SocketChannel channel = (SocketChannel)key.channel();

                    //获取到该channel关联的buffer
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int read = channel.read(buffer);
                    if (read > 0){
                        byte[] data = buffer.array();
                        String msg = new String(data).trim();
                        System.out.println(msg);
                        System.out.println(StandardCharsets.UTF_8.decode(buffer).toString());
                    }
                    //System.out.println("来自客户端发送的数据是："+new String(buffer.array()));
                    //System.out.println("UTF8转码之后"+ StandardCharsets.UTF_8.decode(buffer).toString());
                }
                //手动从集合中移动当前的selectionKey，防止重复操作
                keyIterator.remove();
            }
        }
    }
}
