package com.waibizi.C63;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
/**
 * @author 歪鼻子
 * @version 1.0
 * @date 2020/4/21 1:09
 */
public class TimePrinter implements ActionListener {
    /**
     * 当前ActionEvent对象中有一段逻辑，需要此方法来决定具体的调用情况
     * 解耦是目的，切记不要为了回调而去回调。
     * 所有的代码都是符合正常的思维逻辑去进行，
     * 而不是你了解了回调，处处回调去显摆你的代码
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("At the tone,the time is"+ Instant.ofEpochMilli(event.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }
}
