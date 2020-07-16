package com.waibizi.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author 歪鼻子
 * @Date 2020/6/19 17:09
 * @Description:
 * @Version 1.0
 */
public class NIOServer {
    //中央控制器
    private Selector selector;
    //创建线程池
    ThreadPoolExecutor threadPool =
            new ThreadPoolExecutor(8,16,
                    10, TimeUnit.SECONDS,new SynchronousQueue<>(),
                    Executors.defaultThreadFactory());
    //字符编码对象
    private Charset charSet = StandardCharsets.UTF_8;

    private ByteBuffer welcome = ByteBuffer.wrap("欢迎访问歪鼻子公众号，告诉我你名字可以吗?".getBytes());

    private ServerSocketChannel serverSocketChannel;

    /**
     * 初始化NIO服务端
     * @param port 绑定的端口号
     * @throws IOException
     */
    public void initServer(int port) throws IOException {
        //创建一个选择器
        selector = Selector.open();
        //获得一个ServerSocket通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //设置通道为非阻塞
        serverSocketChannel.configureBlocking(false);
        //将该通道对应的ServerSocket绑定到port端口
        serverSocketChannel.bind(new InetSocketAddress(port));
        //将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件，注册该事件后
        //当该事件到达后,selector.select()会返回，如果该事件没到达selector.select()会一直阻塞
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    /**
     * 采用轮询的方式监听selector上是否有需要处理的事件，如果有的话，则进行处理
     * @throws IOException
     */
    public void listen() throws IOException {
        System.out.println("服务端启动成功！");
        //轮询访问selector
        while (true){
            selector.select();
            //获得selector中选中的项的迭代器，选中的项为注册的事件
            Iterator<?> iterator = selector.selectedKeys().iterator();
            while(iterator.hasNext()){
                SelectionKey key = (SelectionKey) iterator.next();
//                //删除已经选择的key，防止重复处理
                iterator.remove();
                handler(key);
            }
            //清空选择建
            selector.selectedKeys().clear();
        }
//        while(selector.select()>0){
//            //获得selector中选中的项的迭代器，选中的项为注册的事件
//            Iterator<?> iterator = selector.selectedKeys().iterator();
//            while(iterator.hasNext()){
//                SelectionKey key = (SelectionKey) iterator.next();
////                //删除已经选择的key，防止重复处理
//                iterator.remove();
//                handler(key);
//            }
//        }
    }
    /**
     * 处理请求
     * @param key
     */
    public void handler(SelectionKey key) throws IOException {
        //如果key是有效的并且key是可接收的
        if (key.isValid())if (key.isAcceptable())handlerAccept(key);
        //获得了可读事件
        else if(key.isReadable()){
            //清楚可读标记
            key.interestOps(key.interestOps()&~key.interestOps());
            //采用线程池管理
            threadPool.execute(()->{
                try {
                    handlerRead(key);
                    System.out.println("处理业务的时候创建的线程标识是"+Thread.currentThread().getId());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        }
    }
    /**
     * 处理连接请求
     * @param key
     * @throws IOException
     */
    public void handlerAccept(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        //获得和客户端连接的通道
        SocketChannel channel = serverSocketChannel.accept();
        //设置成非阻塞
        channel.configureBlocking(false);
        //在这里可以给客户端发送信息
        System.out.println("新的客户端连接");
        //在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限
        channel.register(selector,SelectionKey.OP_READ);
//        //回写连接信息
//        channel.write(welcome.duplicate());
        welcome.flip();
        channel.write(welcome);
    }

    /**
     * 处理读的事件
     * @param key
     * @throws IOException
     */
    public void handlerRead(SelectionKey key) throws IOException {

        //服务器可以读取消息：获取事件发生的socket通道
        SocketChannel channel = (SocketChannel) key.channel();
        //创建读取的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder stringBuilder = new StringBuilder();
        while(channel.read(buffer) > 0){
            buffer.flip();
            stringBuilder.append(charSet.decode(buffer));
            buffer.clear();

        }
        //未注册判断
        if (key.attachment()==null) {
            String[] split = stringBuilder.toString().split("register:->");
            key.attach(split[1]);
            mutilcast(key,String.format("%s:已上线",split[1]));
        }
        //接收发送的消息
        else{
            mutilcast(key,String.format("%s 说 %s",key.attachment(),stringBuilder.toString()));
        }
        //准备接收下一个消息
        key.interestOps(key.interestOps()|SelectionKey.OP_READ);

    }

    /**
     * 发送广播消息
     * @param selectionKey
     * @param content 发送的消息
     */
    private void mutilcast(SelectionKey selectionKey,String content){
        selector.keys().forEach(key->{
            if (key.channel() instanceof SocketChannel&&selectionKey!=key){
                try {
                    ((SocketChannel) key.channel()).write(ByteBuffer.wrap(content.getBytes()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
    }
    /**
     * 关闭服务端
     * @throws IOException
     */
    public void close() throws IOException {
        serverSocketChannel.close();
        selector.close();
    }
}
