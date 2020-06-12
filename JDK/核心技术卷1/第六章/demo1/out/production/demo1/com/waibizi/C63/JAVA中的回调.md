# JAVA中的回调

**回调（callback）**是一种常见的程序设计模式。

在这种模式中，可以指定某个特定时间发生时应该采取的动作。

![image-20200421015118800](C:\Users\waibizi\AppData\Roaming\Typora\typora-user-images\image-20200421015118800.png)

```
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
```

```
package com.waibizi.C63;
import javax.swing.*;
/**
 * @author 歪鼻子
 * @version 1.0
 * @date 2020/4/21 1:08
 */
public class TimerTest {
    public static void main(String[] args) {
        var listener = new TimePrinter();
        var timer = new Timer(100,listener);
        timer.start();
        JOptionPane.showMessageDialog(null,"I'm fine");
        System.exit(0);
    }
}
```