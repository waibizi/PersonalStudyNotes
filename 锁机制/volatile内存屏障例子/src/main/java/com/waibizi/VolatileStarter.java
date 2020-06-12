package com.waibizi;

/**
 * @Author 歪鼻子
 * @Date 2020/6/11 17:14
 * @Description:
 * @Version 1.0
 */
public class VolatileStarter {
    public static void main(String[] args) throws InterruptedException {
        VolatileData volatileData = new VolatileData();
        ReadTask read = new ReadTask(volatileData);
        WriteTask write = new WriteTask(volatileData);

        new Thread(read).start();
        Thread.sleep(500);
        new Thread(write).start();
    }
}
