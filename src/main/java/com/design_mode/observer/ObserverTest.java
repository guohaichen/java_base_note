package com.design_mode.observer;

/**
 * @author cgh
 * @create 2022-09-02 14:26
 */
public class ObserverTest {
    public static void main(String[] args) {
        SubscriptionSubject subscriptionSubject = new SubscriptionSubject();

        WeChatUser user1 = new WeChatUser("chenGuoHai");
        WeChatUser user2 = new WeChatUser("liPengYan");
        WeChatUser user3 = new WeChatUser("sdsd");
        WeChatUser user4 = new WeChatUser("xxyy");

        subscriptionSubject.attach(user1);
        subscriptionSubject.attach(user2);
        subscriptionSubject.attach(user3);
        subscriptionSubject.attach(user4);

        subscriptionSubject.detach(user4);

        subscriptionSubject.wakeupUser("微信读书专栏更新了!");
    }
}
