package com.waibizi.List;

/**
 * 手写ArrayList
 * ArrayList比Vector高效
 * 底层是使用数组方式实现
 * 怎么保证集合存放无限大小----数组扩容机制
 * ArrayList数据扩容机制采用了
 *            参数    src原数组  srcPos起始位置  dest目标数组    destPos目标起始位置   length复制长度
 * arraycopy(Object src,  int  srcPos,Object dest, int destPos,int length);
 * @author 歪鼻子
 * @version 1.0
 * @date 2020/4/23 21:40
 */
public class ArrayList {
    public static void main(String[] args) {
        //System.arraycopy();
    }
}
