package com.waibizi.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author 歪鼻子
 * @Date 2020/6/10 18:11
 * @Description: Channel_02从D盘读取数据
 * @Version 1.0
 */
public class Channel_02 {
    public static void main(String[] args) throws IOException {
        //创建文件的输入流
        File file = new File("D:\\channel.txt");
        FileInputStream fis = new FileInputStream(file);

        //通过文件的输入流获取文件的管道
        FileChannel fileChannel = fis.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());
        //将管道中的值放到缓冲区当中
        fileChannel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array()));
        fis.close();
    }
}
