package com.design_mode.adapter;

/**
 * @author cgh
 * @create 2022-08-26 10:28
 */
public class TFCardImpl implements TFCard {
    @Override
    public void readFromTF(String msg) {
        System.out.println("read the msg : " + msg + " from TFCard");
    }
}
