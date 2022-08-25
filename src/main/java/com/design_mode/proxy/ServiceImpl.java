package com.design_mode.proxy;

/**
 * @author cgh
 * @create 2022-06-18 13:53
 */ //1.2 实现接口
public class ServiceImpl implements Service {
    @Override
    public void print(String message) {
        System.out.println("print message:" + message);
    }
}
