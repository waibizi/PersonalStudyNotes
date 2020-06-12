package com.waibizi.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @Author 歪鼻子
 * @Date 2020/6/11 0:45
 * @Description:
 * @Version 1.0
 */
public class Channel_04 {
    public static void main(String[] args) throws IOException {
        //创建相关的流
        FileInputStream fileInputStream = new FileInputStream("D:\\waibizi_1.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\waibizi_2.jpg");

        //获取各个流对应的通道
        FileChannel source = fileInputStream.getChannel();
        FileChannel target = fileOutputStream.getChannel();
        //使用transferForm完成拷贝
        target.transferFrom(source,0,source.size());
        //关闭相关通道和流
        source.close();
        target.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
