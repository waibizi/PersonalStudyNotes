package com.waibizi;

/**
 * @Author 歪鼻子
 * @Date 2020/6/29 17:29
 * @Description:
 * @Version 1.0
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
       ClassLoader myClassLoader = new ClassLoader() {
           @Override
           public Class<?> loadClass(String name) throws ClassNotFoundException {
               return super.loadClass(name);
           }
       };
    }
}
