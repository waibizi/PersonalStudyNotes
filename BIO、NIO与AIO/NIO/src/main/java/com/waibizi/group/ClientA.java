package com.waibizi.group;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Author 歪鼻子
 * @Date 2020/7/9 16:34
 * @Description:
 * @Version 1.0
 */
public class ClientA {
    /* 服务的IP地址 */
    private final String HOST = "127.0.0.1";
    /* 服务的端口 */
    private final int PORT = 2048;
    private Selector selector;
    private SocketChannel socketChannel;
    private String name;

    public ClientA() throws IOException {
        /* 打开选择器 */
        selector = Selector.open();
        /* 连接服务器 */
        socketChannel = SocketChannel.open(new InetSocketAddress(HOST,PORT));
        /* 设置为非阻塞状态 */
        socketChannel.configureBlocking(false);
        /* 将通道注册到选择器上 */
        socketChannel.register(selector, SelectionKey.OP_READ);
        name = "ClientA";
        System.out.println(name+" is ok····");
    }
    public void send(String info){
        info = name + "说："+info;
        try {
            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void read() throws IOException {
        while (selector.select()>0){
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if (key.isReadable()){
                    /* 得到相关的通道 */
                    SocketChannel channel = (SocketChannel) key.channel();
                    /* 得到一个buffer */
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    /* 读取 */
                    channel.read(buffer);
                    System.out.println(new String(buffer.array()).trim());
                }
            }
            iterator.remove();
        }
    }

    public static void main(String[] args) throws IOException {
        /* 启动客户端 */
        ClientA client = new ClientA();
        new Thread(()->{
            while (true){
                try {
                    client.read();
                    Thread.currentThread().sleep(3000L);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        /* 向客户端发送数据 */
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String msg = scanner.nextLine();
            client.send(msg);
        }
    }
}
