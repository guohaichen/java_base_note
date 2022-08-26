package com.design_mode.adapter.classAdapter;

/**
 * @author cgh
 * @create 2022-08-26 10:28
 * 适配器模式，PhoneClient可以直接读取SDCard，而不能直接读取TFCard;
 * 通过 SDCardAdapter 实现了SDCard的业务接口，又同时继承TFCardImpl类
 */
public class PhoneClient {
    static SDCard sdCard = new SDCardImpl();
    static SDCardAdapter sdCardAdapter = new SDCardAdapter();

    public static void main(String[] args) {
        readMessage(sdCard);
        System.out.println("====================================");
        //
        readMessage(sdCardAdapter);
    }

    //读取消息，只能接受SDCard类型，而不能是TFCard类型
    public static void readMessage(SDCard sdCard) {
        sdCard.readFromSD("hello world!");
    }
}
