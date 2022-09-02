package com.design_mode.observer;

/**
 * @author cgh
 * @create 2022-09-02 13:39
 */
public class WeChatUser implements MyObserver {

    private final String name;

    public WeChatUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
