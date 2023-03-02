package com.design_mode.singleton.demo;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author cgh
 * @create 2023-03-01 11:24
 * 设计模式之美：之前写过的都是进程之间的单例，这个是线程的单例模式
 * 进程唯一的单例：进程内唯一，线程内唯一，进程间不唯一、
 * 线程唯一的单例：线程内唯一，线程间不唯一、
 * 集群唯一的单例：线程间，进程间都唯一，也就是说不同的进程间共享同一个对象，不能创建一个类的多个对象。（分布式锁）
 */
public class ThreadSingleton {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(()-> System.out.println(IdGenerator.getInstance().getId())).start();
        }
    }
}
//一个发号器，使用hashMap通过线程id来控制线程的单例，ThreadLocal底层也是通过hashMap这样的原理实现。
class IdGenerator{
    private  AtomicLong id = new AtomicLong(0);
    private static final ConcurrentHashMap<Long, IdGenerator> instances = new ConcurrentHashMap<>();
    private IdGenerator() {}

    public static IdGenerator getInstance(){
        long threadId = Thread.currentThread().getId();
        instances.putIfAbsent(threadId,new IdGenerator());
        return instances.get(threadId);
    }
    public long getId(){
        return id.incrementAndGet();
    }
}
