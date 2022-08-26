package com.design_mode.adapter.objectAdapter;

import com.design_mode.adapter.SDCard;
import com.design_mode.adapter.TFCardImpl;

/**
 * @author cgh
 * @create 2022-08-26 13:47
 * 对象适配器举例
 */
public class PhoneClient {
    public static void main(String[] args) {
        SDAndTFCardAdapter sdAndTFCardAdapter = new SDAndTFCardAdapter(new TFCardImpl());
        readMessage(sdAndTFCardAdapter);
    }

    //规定一个方法必须对象必须为SDCard类，
    static public void readMessage(SDCard sdCard){
        sdCard.readFromSD("hello");
    }
}
