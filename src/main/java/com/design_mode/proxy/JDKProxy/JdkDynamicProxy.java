package com.design_mode.proxy.JDKProxy;

import com.design_mode.proxy.Service;
import com.design_mode.proxy.ServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author cgh
 * @create 2022-06-18 13:59
 */
public class JdkDynamicProxy {
    public static void main(String[] args) {

        ServiceImpl serviceImpl = new ServiceImpl();
        //classLoader
        ClassLoader classLoader = JdkDynamicProxy.class.getClassLoader();

        Service proxyService = (Service) Proxy.newProxyInstance(classLoader, new Class[]{Service.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before");
                //通过反射使用方法
                Object result = method.invoke(serviceImpl, args);
                System.out.println("after");
                return result;
            }
        });
        //代理对象调用方法；
        proxyService.print("2");
    }

}
