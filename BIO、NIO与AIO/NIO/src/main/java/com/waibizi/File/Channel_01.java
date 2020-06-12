package com.waibizi.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author 歪鼻子
 * @Date 2020/6/10 17:09
 * @Description: Channel_01输出文件到D盘下
 * @Version 1.0
 */
public class Channel_01 {
    public static void main(String[] args) throws IOException {

        String text = "Hello World waibizi";
        //创建一个输出流，然后转换为Channel
        FileOutputStream fos = new FileOutputStream("D:\\channel.txt");
        //通过fos获取对应的FileChannel
        FileChannel fileChannel = fos.getChannel();
        //创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //将text放入缓冲区
        byteBuffer.put(text.getBytes());
        //对buffer进行翻转
        byteBuffer.flip();
        //将buffer中的数据集写入到通道里面
        fileChannel.write(byteBuffer);
        fos.close();

    }
}
