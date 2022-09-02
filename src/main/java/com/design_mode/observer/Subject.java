package com.design_mode.observer;

/**
 * @author cgh
 * @create 2022-09-02 13:40
 * 抽象主题类，
 */
public interface Subject {
    //增加订阅者
    void attach(MyObserver myObserver);

    //删除订阅者
    void detach(MyObserver myObserver);

    //通知订阅者更新消息
    void wakeupUser(String message);
}
