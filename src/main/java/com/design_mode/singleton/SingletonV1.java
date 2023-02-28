package com.design_mode.singleton;

/**
 * @author cgh
 * @create 2022-07-27 9:22
 * 单例模式
 * - 饿汉式，通过静态变量，object随着类的加载就创建了。
 * 缺点：不支持延迟加载，如果占用内存过多或初始化耗时长，提前初始化实例是一种浪费资源的行为。最好的方法应该是需要用到时再去初始化。
 * 其实不然，如果初始化耗时过长，最好不要等到需要用到时再去初始化，这会影响到系统的性能，例如相应客户端请求时，这时候去初始化，反而增加了接口的响应时间，甚至超时。
 * 如果资源占用内存过多，我们也希望它能在程序启动时就初始化好。如果内存不够，就会在程序启动时抱错PermGen Space OOM，我们能及时修复。
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

