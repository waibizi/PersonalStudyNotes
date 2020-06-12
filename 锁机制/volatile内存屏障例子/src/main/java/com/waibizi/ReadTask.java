package com.waibizi;

/**
 * @Author 歪鼻子
 * @Date 2020/6/11 17:07
 * @Description:
 * @Version 1.0
 */
public class ReadTask implements Runnable{
    private VolatileData volatileData;
    public ReadTask(VolatileData volatileData){
        this.volatileData = volatileData;
    }
    @Override
    public void run() {

        while (true){
            try {
                volatileData.read();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
