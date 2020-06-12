package com.waibizi;

import com.waibizi.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 歪鼻子
 * @version 1.0
 * @date 2020/5/6 15:34
 */
public class Controller extends BaseController {
    public static final Logger logger = LoggerFactory.getLogger(Controller.class);
    public static void main(String[] args) {
        new Controller();
        logger.info("hahahhaha");
    }
}
