package com.design_mode.singleton;

import java.lang.management.ThreadInfo;

/**
 * @author cgh
 * @create 2022-07-27 10:33
 * 单例模式
 * - 懒汉式，等需要时再创建
 */
public class SingletonV2 {

    //懒汉式vs饿汉式区别:  饿汉式随着类的加载，对象就创建好了。懒汉式等需要的时候再创建;
    private static SingletonV2 instance = null;

    //私有构造
    private SingletonV2() {
        System.out.println("construct");
    }

    //对外提供public 获取对象方法
    public static  SingletonV2 getInstance()   {
        //如果还没创建，就创建返回一个，这里其实是有并发安全问题，多个线程都都进行if判断，都为null，都会去创建；解决方法——>加锁-->代码优化——>双检锁
        if (instance == null) {
            instance = new SingletonV2();
        }
        return instance;
    }

    //创建多个线程来测试, 在构造方法中输出了construct，如果construct输出多次，则说明创建了多个对象
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(SingletonV2::getInstance).start();
        }
    }
}
