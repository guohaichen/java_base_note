package com.design_mode.singleton;

/**
 * @author cgh
 * @create 2022-08-24 10:26
 * 单例模式：静态内部类模式
 *  静态内部类单例模式由内部类创建，由于JVM在加载外部类的过程中，是不会加载静态静态内部类，
 *  只有内部类的属性/方法被调用时才会被加载，并初始化其静态属性。(懒汉式)
 *  静态属性由于被static修饰，JVM保证只被实例化一次，并且严格保证实例化顺序。
 */
public class SingletonV5 {
    //构造私有
    private SingletonV5() {}
    //静态内部类
    private static class SingleHolder {
        private final static SingletonV5 INSTANCE = new SingletonV5();
    }
    //对外提供静态方法获取该对象
    public static SingletonV5 getInstance(){
        return SingleHolder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(SingletonV5.getInstance().hashCode());
            }).start();
        }
    }
}
