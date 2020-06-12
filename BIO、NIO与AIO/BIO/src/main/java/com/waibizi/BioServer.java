package com.waibizi;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @Author 吴典秋
 * @Date 2020/6/6 13:42
 * @Description: BIO的服务端
 * @Version 1.0
 */
public class BioServer {
    public static void main(String[] args) throws IOException {
        //采用线程池机制
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor
                        (8,16,10,
                                TimeUnit.SECONDS,new SynchronousQueue<Runnable>(),
                                Executors.defaultThreadFactory());
        //创建一个端口为1024的ServerSocket
        ServerSocket serverSocket = new ServerSocket(1024);
        System.out.println("服务器启动了");
        while (true){
            System.out.println("使服务器的线程名称为:"+Thread.currentThread().getName());
            //监听、等待客户端的连接
            System.out.println("等待连接当中");
            final Socket socket = serverSocket.accept();
            System.out.println("有客户端连接进来了");
            threadPoolExecutor.execute(()->{
                handler(socket);
            });
        }
    }

    public static void handler(Socket socket){
        try{
            System.out.println("通讯的线程名称为:"+Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            //通过socket获取输入流
            InputStream inputStream = socket.getInputStream();
            while (true){
                System.out.println("进行信息交流的线程名称为:"+Thread.currentThread().getName());
                System.out.println("Reading········");
                int read = inputStream.read(bytes);
                if (read!=-1){
                    System.out.println(new String(bytes,0,read));
                }else {
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("关闭与客户端的连接");
            try {
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
