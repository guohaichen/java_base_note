package com.design_mode.proxy.staticProxy;

import com.design_mode.proxy.ServiceImpl;

/**
 * @author cgh
 * @create 2022-06-18 13:53
 */ //测试
class StaticProxyTest {
    public static void main(String[] args) {
        ServiceImpl serviceImpl = new ServiceImpl();

        StaticProxy staticProxy = new StaticProxy(serviceImpl);
        //调用代理类的方法
        staticProxy.print("static proxy");
    }
}
