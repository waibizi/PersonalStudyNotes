package com.waibizi;

/**
 * @Author 歪鼻子
 * @Date 2020/6/11 17:09
 * @Description:
 * @Version 1.0
 */
public class WriteTask implements Runnable{
    private VolatileData volatileData;

    public WriteTask(VolatileData volatileData) {
        this.volatileData = volatileData;
    }

    @Override
    public void run() {
        volatileData.write();
    }
}
