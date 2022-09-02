package com.design_mode.observer.inJDK;

import java.util.Observable;

/**
 * @author cgh
 * @create 2022-09-02 15:14
 * 小偷类，被观察者
 */
public class Thief extends Observable {
    private String name;

    public Thief(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void steal(){
        System.out.println("小偷:\t我偷东西了，有没有人来抓我！");
        super.setChanged();
        super.notifyObservers();
    }
}
