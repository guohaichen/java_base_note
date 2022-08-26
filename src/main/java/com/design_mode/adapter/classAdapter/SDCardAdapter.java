package com.design_mode.adapter.classAdapter;

/**
 * @author cgh
 * @create 2022-08-26 11:00
 */
public class SDCardAdapter extends TFCardImpl implements SDCard {
    //重写接口中的方法，去调继承类的方法
    @Override
    public void readFromSD(String msg) {
        System.out.println("SDCardAdapter is worked!");
        readFromTF(msg);
    }
}
