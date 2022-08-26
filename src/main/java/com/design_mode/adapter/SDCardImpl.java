package com.design_mode.adapter;

/**
 * @author cgh
 * @create 2022-08-26 10:10
 */
public class SDCardImpl implements SDCard {
    @Override
    public void readFromSD(String msg) {
        System.out.println("read the msg :" + msg+" from SD_card");
    }
}
