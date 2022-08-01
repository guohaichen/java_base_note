package com.design_mode.proxy.staticProxy;

import com.base.spring.proxy.base.Service;
import com.base.spring.proxy.base.ServiceImpl;

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
    public String print(String message) {
        System.out.println("proxy before");
        serviceImpl.print(message);
        System.out.println("proxy after");
        return message;
    }
}
