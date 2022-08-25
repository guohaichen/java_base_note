package com.design_mode.proxy.JDKProxy;

import com.design_mode.proxy.Service;

/**
 * @author cgh
 * @create 2022-08-25 14:49
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        JdkDynamicProxy jdkDynamicProxy = new JdkDynamicProxy();
        Service proxy = jdkDynamicProxy.getProxy();
        System.out.println("jdk 代理前 功能增强代码");
        proxy.print("jdk proxy");
        System.out.println("jdk 代理后 功能增强代码");
    }
}
