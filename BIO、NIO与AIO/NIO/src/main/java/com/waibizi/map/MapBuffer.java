package com.waibizi.map;

import org.omg.CORBA.portable.InputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author 歪鼻子
 * @Date 2020/6/11 1:59
 * @Description:
 * @Version 1.0
 */
public class MapBuffer {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("waibizi_1.txt","rw");
        //获取相应的通道
        FileChannel channel = randomAccessFile.getChannel();
        /**
         * mode: FileChannel.MapMode.READ_WRITE 使用的读写模式
         * position: 可以直接修改的起始位置
         * size: 是映射到内存的大小(不是索引位置)
         *
         */
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE,0,5);
        mappedByteBuffer.put(0,(byte)'A');
        mappedByteBuffer.put(3,(byte)'B');
        mappedByteBuffer.put(4,(byte)'C');
        randomAccessFile.close();
        System.out.println("修改成功啦");
    }
}
