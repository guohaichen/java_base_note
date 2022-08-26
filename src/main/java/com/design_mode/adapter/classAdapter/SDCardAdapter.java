package com.design_mode.adapter.classAdapter;

import com.design_mode.adapter.SDCard;
import com.design_mode.adapter.TFCardImpl;

/**
 * @author cgh
 * @create 2022-08-26 11:00
 * 类适配器模式
 * 通过 SDCardAdapter 实现了SDCard的业务接口，又同时继承TFCardImpl类
 */
public class SDCardAdapter extends TFCardImpl implements SDCard {
    //重写接口中的方法，去调继承类的方法
    @Override
    public void readFromSD(String msg) {
        System.out.println("SDCardAdapter is worked!");
        readFromTF(msg);
    }
}
