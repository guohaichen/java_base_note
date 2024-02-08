package com.design_mode.observer.inJDK;

import java.util.Observable;
import java.util.Observer;

/**
 * @author cgh
 * @create 2022-09-02 15:25
 */
public class Policemen implements Observer {

    private String name;

    public Policemen(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(getName() + ":\t" + ((Thief) o).getName() + "，我已经盯上你了");
    }
}
