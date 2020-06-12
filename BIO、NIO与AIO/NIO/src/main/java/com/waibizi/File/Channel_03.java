package com.waibizi.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author 歪鼻子
 * @Date 2020/6/10 23:54
 * @Description: 将一个文件的内容读出，写入到另外一个文件当中去
 * @Version 1.0
 */
public class Channel_03 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("waibizi_1.txt");
        FileChannel fileChannel_1 = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("waibizi_2.txt");
        FileChannel fileChannel_2 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true){
            byteBuffer.clear();
            int read = fileChannel_1.read(byteBuffer);
            if (read == -1){
                break;
            }
            //将buffer中的数据写入到第二条管道中当中
            byteBuffer.flip();
            fileChannel_2.write(byteBuffer);
        }
    }
}
