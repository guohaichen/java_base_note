package com.design_mode.singleton;

/**
 * @author cgh
 * @create 2022-07-27 9:22
 * 单例模式
 * - 饿汉式，通过静态变量，object随着类的加载就创建了。
 */
public class SingletonV1 {
    //静态变量
    private static final  SingletonV1 instance = new SingletonV1();

    //私有化构造方法，不对外提供创建方法
    private SingletonV1() { }

    //对外提供public 获取对象方法
    public static SingletonV1 getInstance() {
        return instance;
    }

    public static void main(String[] args) throws InterruptedException {
        SingletonV1 object1 = SingletonV1.getInstance();
        SingletonV1 object2 = SingletonV1.getInstance();
        System.out.println(object1 == object2);


        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                System.out.println(object1==SingletonV1.getInstance());
            }).start();
        }
        Thread.sleep(2000);
        System.out.println("main over");
    }
}

