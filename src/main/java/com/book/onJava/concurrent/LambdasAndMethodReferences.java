package com.book.onJava.concurrent;

import java.util.concurrent.*;

/**
 * @author cgh
 * @create 2022-07-10 15:00
 *
 * on java 进阶 p237
 * 将非Runnable或Callable类型的参数传递给ExecutorService
 *
 */
public class LambdasAndMethodReferences {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Future<?> lambda1 = threadPool.submit(() -> System.out.println("Lambda1"));

        Future<?> runnable = threadPool.submit(new NotRunnable()::go);

        threadPool.submit(() -> {
            System.out.println("lambda2");
            return 1;
        });

        Future<Integer> result = threadPool.submit(new NotCallable()::get);

        threadPool.shutdown();
        System.out.println(result.get());
        System.out.println(lambda1.get());
        System.out.println(runnable.get());
    }
}

class NotRunnable{
    public void go(){
        System.out.println("Not Runnable");
    }
}
class NotCallable{
    public Integer get(){
        System.out.println("Not Callable");
        return 5;
    }
}
