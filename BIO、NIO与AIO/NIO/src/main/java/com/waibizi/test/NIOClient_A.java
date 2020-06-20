package com.waibizi.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author 歪鼻子
 * @Date 2020/6/20 2:20
 * @Description:
 * @Version 1.0
 */
public class NIOClient_A {
    private Charset charset = StandardCharsets.UTF_8;
    private Selector selector;
    private SocketChannel socketChannel;

    /**
     * 初始化客户端
     * @throws IOException
     */
    public void init(int port) throws IOException {
        selector = Selector.open();
        socketChannel = SocketChannel.open();
        //配置为非阻塞模式
        socketChannel.configureBlocking(false);
        //注册读状态
        socketChannel.register(selector, SelectionKey.OP_READ);
        //连接服务器
        socketChannel.connect(new InetSocketAddress("localhost",port));
    }

    /**
     * 开始读取服务端发送的内容
     * @throws IOException
     */
    public void start(){
        new Thread(() -> {
            try {
                while (selector.select() > 0){
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    if (iterator.hasNext()){
                        SelectionKey key = iterator.next();
                        if (key.isValid())if (key.isReadable()){
                            SocketChannel channel = (SocketChannel) key.channel();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            StringBuilder stringBuilder = new StringBuilder();
                            while (channel.read(byteBuffer) > 0) {
                                byteBuffer.flip();
                                stringBuilder.append(charset.decode(byteBuffer));
                                byteBuffer.clear();
                            }
                            System.out.println(stringBuilder.toString());
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();

    }

    /**
     * 发送消息
     * @throws IOException
     */
    public void write() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String msg;
        while ((msg = scanner.nextLine())!=null){
            socketChannel.write(charset.encode(msg));
        }
        
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        NIOClient_A Client_A = new NIOClient_A();
                    Client_A.init(6666);
                    Thread.sleep(300L);
                    Client_A.start();
                    Client_A.write();
    }
}
