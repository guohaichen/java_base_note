package com.book.onJava.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author cgh
 * @create 2022-07-10 16:27
 */
public class QuittableTask implements Runnable{
    final int id;

    public QuittableTask(int id) {
        this.id = id;
    }

    private AtomicBoolean running = new AtomicBoolean(true);
    public void quit(){running.set(false);}

    @Override
    public void run() {
        while (running.get()){
            new Nap(0.1);
        }
        System.out.print(id+" ");
    }
}
