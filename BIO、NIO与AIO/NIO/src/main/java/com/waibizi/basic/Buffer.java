package com.waibizi.basic;

import java.nio.IntBuffer;

/**
 * @Author 吴典秋
 * @Date 2020/6/9 0:11
 * @Description:
 * @Version 1.0
 */
public class Buffer {
    public static void main(String[] args) {
        //分配五个空间的大小
        IntBuffer intBuffer = IntBuffer.allocate(5);
        for (int i = 0;i<5;i++){
            intBuffer.put(i*2);
        }
        //将缓存区进行翻转，变成可输出到管道的模式
        intBuffer.flip();
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }

    }

}
