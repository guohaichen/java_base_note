package com.design_mode.proxy.JDKProxy;

import com.design_mode.proxy.Service;
import com.design_mode.proxy.ServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author cgh
 * @create 2022-06-18 13:59
 * jdk动态代理
 */
public class JdkDynamicProxy {
    public Service getProxy() {
        ServiceImpl serviceImpl = new ServiceImpl();
        //获得需要代理的类的类加载器
        ClassLoader classLoader = ServiceImpl.class.getClassLoader();
        /*
        loader – the class loader to define the proxy class
        interfaces – the list of interfaces for the proxy class to implement
        h – the invocation handler to dispatch method invocations to
         */
        Service proxyService = (Service) Proxy.newProxyInstance(classLoader, new Class[]{Service.class}, new InvocationHandler() {
            @Override
            /*
            proxy 为代理对象
            method 对应于在代理对象上调用的接口方法的Method实例
            args 代理对象调用接口方法时传递的实际参数
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //通过反射使用方法
                Object result = method.invoke(serviceImpl, args);
                return result;
            }
        });
        return proxyService;
    }

}
