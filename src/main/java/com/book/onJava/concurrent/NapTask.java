package com.book.onJava.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author cgh
 * @create 2022-07-10 16:06
 * p229基础demo类
 */
public class NapTask implements Runnable {
    final int id;
    public NapTask(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        new Nap(0.1);
        System.out.println(this + " " + Thread.currentThread().getName());
    }
    @Override
    public String toString() {
        return "NapTask{" + "id=" + id + '}';
    }
}

class Nap {
    public Nap(double t) {
        try {
            TimeUnit.MILLISECONDS.sleep((int) (1000 * t));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public Nap(Double t, String msg) {
        this(t);
        System.out.println(msg);
    }
}
