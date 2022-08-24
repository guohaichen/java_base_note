package com.design_mode.singleton;

/**
 * @author cgh
 * @create 2022-07-27 11:02
 * 懒汉式 单例模式解决并发安全问题 以及优化
 * double check lock
 */
public class SingletonV3 {

    private static volatile SingletonV3 instance = null;

    private SingletonV3() {
        System.out.println("construct");
    }

    /**
     * 1.线程安全的单例模式
     * 一：方法上加synchronized
     * 二：dcl 双检锁
     */

    public static SingletonV3 getInstance() {
        if (instance == null) {
            synchronized (SingletonV3.class) {
                /**
                 * 第二个判断instance为空：
                 * 当 instance 为 null 时，两个线程可以并发地进入 if 语句内部。然后，一个线程进入 synchronized 块来初始化 instance，
                 * 而另一个线程则被阻断。当第一个线程退出 synchronized 块时，等待着的线程进入并创建另一个 Singleton 对象。
                 * 注意：当第二个线程进入 synchronized 块时，它并没有检查 instance 是否非 null。
                 */
                if (instance == null) {
                    instance = new SingletonV3();
                }
            }
        }
        return instance;
    }


    //创建多个线程来测试, 在构造方法中输出了construct，如果construct输出多次，则说明创建了多个对象
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(SingletonV3::getInstance).start();
        }
    }
}
