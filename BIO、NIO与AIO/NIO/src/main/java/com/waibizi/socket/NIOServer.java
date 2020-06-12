package com.waibizi.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
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
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //把serverSocketChannel注册到selector关联时间OP_ACCEPT
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
                //根据key对应的通道发生的事件做相应的处理 : 如果是OP_ACCEPT表示有新的客户端连接
                if (key.isAcceptable()){
                    //该客户端生成一个SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端连接成功！生成了一个socketChannel"+socketChannel.hashCode());
                    //将SocketChannel 设置为非阻塞
                    socketChannel.configureBlocking(false);
                    //将socketChannel注册到selector，关注事件为OP_READ,同时给socketChannel
                    //关联到一个Buffer
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    System.out.println("客户端连接后，注册到selectionKey的数量 = "+selector.keys().size());
                }
                //如果发生了OP_READ
                if (key.isReadable()){
                    //通过key反向获取到对应的Channel
                    SocketChannel channel = (SocketChannel)key.channel();
                    //获取到该channel关联的buffer
                    ByteBuffer buffer = (ByteBuffer)key.attachment();
                    channel.read(buffer);
                    System.out.println("来自客户端"+new String(buffer.array()));
                }
                //手动从集合中移动当前的selectionKey，防止重复操作
                keyIterator.remove();

            }
        }
    }
}
