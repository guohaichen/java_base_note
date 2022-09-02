package com.design_mode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cgh
 * @create 2022-09-02 14:13
 */
public class SubscriptionSubject implements Subject{
    //储存订阅公众号的微信用户
    private final List<MyObserver> weChatUserList = new ArrayList<>();

    @Override
    public void attach(MyObserver myObserver) {
        weChatUserList.add(myObserver);
    }

    @Override
    public void detach(MyObserver myObserver) {
        weChatUserList.remove(myObserver);
    }

    @Override
    public void wakeupUser(String message) {
        for (MyObserver myObserver : weChatUserList) {
            myObserver.update(message);
        }
    }
}
