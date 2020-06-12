package com.waibizi.socket;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
/**
 * @Author 歪鼻子
 * @Date 2020/6/11 2:41
 * @Description: Scattering：将数据写入到buffer时，可以采用buffer数组，依次写入  [分散]
 *               Gathering: 从buffer读取数据时，可以采用buffer数组，依次读
 * @Version 1.0
 */
public class ScatteringAndGathering {
    public static void main(String[] args) throws IOException {
        //采用ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress isa = new InetSocketAddress(2048);

        //给ServerSocketChannel绑定一个端口
        serverSocketChannel.socket().bind(isa);

        //创建buffer数据
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        //等待客户端的连接（telnet）
        SocketChannel socketChannel = serverSocketChannel.accept();
        int MsgSize = 8;
        //循环的读取
        while (true){
            int readByte = 0;
            while (readByte < MsgSize){
                long size = socketChannel.read(byteBuffers);
                readByte += size;
                System.out.println("readByte="+readByte);
                //采用流打印，看看这个buffer的position与limit值的变化情况
                Arrays.stream(byteBuffers).map(buffer ->"position="+ buffer.position()+",limit="+buffer.limit()).forEach(System.out::println);

            }
            //将所有的buffer进行flip
            Arrays.asList(byteBuffers).forEach(Buffer::flip);

            //将数据读出显示到客户端
            long writeByte = 0;
            while (writeByte < MsgSize){
                long size = socketChannel.write(byteBuffers);
                writeByte +=1;
            }
            //将所有的Buffer进行clear
            Arrays.stream(byteBuffers).forEach(Buffer::clear);
            System.out.println("readByte="+readByte+"writeByte="+writeByte+"MsgSize="+MsgSize);
        }
    }
}
