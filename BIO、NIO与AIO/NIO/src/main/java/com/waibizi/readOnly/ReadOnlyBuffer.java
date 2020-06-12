package com.waibizi.readOnly;

import java.nio.ByteBuffer;

/**
 * @Author 歪鼻子
 * @Date 2020/6/11 1:39
 * @Description:
 * @Version 1.0
 */
public class ReadOnlyBuffer {
    public static void main(String[] args) {
        //创建一个buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);

        for (int i = 0;i < 64;i++){
            byteBuffer.put((byte)i);
        }
        //读取
        byteBuffer.flip();
        //得到一个只读的buffer
        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());
        //读取
        while (readOnlyBuffer.hasRemaining()){
            System.out.println(readOnlyBuffer.get());
        }

        //因为值只读buffer，开启下面代码就会报错的
        //byteBuffer.flip();
        //readOnlyBuffer.put((byte)100);
    }
}
