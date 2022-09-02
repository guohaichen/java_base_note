package com.design_mode.proxy.cglibProxy;

import com.design_mode.proxy.ServiceImpl;

/**
 * @author cgh
 * @create 2022-08-25 15:33
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        CglibDynamicProxy proxy = new CglibDynamicProxy();
        ServiceImpl serviceImpl = proxy.getProxy();
        System.out.println("cglib 动态代理功能增强前 code");
        serviceImpl.print("cglib proxy");
        System.out.println("cglib 动态代理功能增强后 code");


        System.out.println(serviceImpl.getClass());
    }
}
