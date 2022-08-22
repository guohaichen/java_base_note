package com.design_mode.singleton;

/**
 * @author cgh
 * @create 2022-08-22 13:32
 * 使用枚举类实现单例
 */
public class SingletonV4 {
    //构造私有
    private SingletonV4() {
    }


    //定义一个静态枚举类
    enum SingletonEnum {
        //创建一个枚举对象，该对象因为Enum类在jvm中的实现天生为单例
        INSTANCE;

        private final SingletonV4 singletonV4;

        //私有化枚举的构造函数
        SingletonEnum() {
            singletonV4 = new SingletonV4();
        }

        public SingletonV4 getInstance() {
            return singletonV4;
        }
    }

    //对外暴露一个获取singletonV4对象的静态方法
    public static SingletonV4 getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }

    //测试是否单例
    public static void main(String[] args) {
        SingletonV4 instance1 = SingletonV4.getInstance();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println(instance1==SingletonV4.getInstance())
            ).start();
        }
    }
}
