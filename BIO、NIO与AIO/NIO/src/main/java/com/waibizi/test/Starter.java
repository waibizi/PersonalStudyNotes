package com.waibizi.test;

import java.io.IOException;

/**
 * @Author 歪鼻子
 * @Date 2020/6/19 17:11
 * @Description:
 * @Version 1.0
 */
public class Starter {
    public static void main(String[] args) throws IOException {
        NIOServer server = new NIOServer();
        server.initServer(6666);
        server.listen();
    }
}
