package com.design_mode.proxy.staticProxy;

import com.design_mode.proxy.Service;
import com.design_mode.proxy.ServiceImpl;

/**
 * @author cgh
 * @create 2022-06-18 13:52
 */ //2.创建代理类
class StaticProxy implements Service {
    private final ServiceImpl serviceImpl;

    //通过构造方法将需要代理的对象
    public StaticProxy(ServiceImpl serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    @Override
    public void print(String message) {
        System.out.println("proxy before");
        serviceImpl.print(message);
        System.out.println("proxy after");
    }
}
