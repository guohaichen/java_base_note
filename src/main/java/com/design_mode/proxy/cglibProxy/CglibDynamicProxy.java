package com.design_mode.proxy.cglibProxy;

import com.design_mode.proxy.ServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author cgh
 * @create 2022-06-18 14:11
 * cglib动态代理，使用cglib包下的Enhancer.create()
 * cglib 不要求目标实现接口，它生成的代理类是目标的子类，因此代理与目标之间是子父关系,故cglib代理不能代理final修饰的类
 */
public class CglibDynamicProxy {
    public ServiceImpl getProxy() {
        ServiceImpl serviceImpl = new ServiceImpl();
        ServiceImpl serviceProxy = (ServiceImpl) Enhancer.create(serviceImpl.getClass(), new MethodInterceptor() {
            //Object[] args 为方法参数
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //反射调用方法
                Object result = method.invoke(serviceImpl, args);
                //cglib可以避免使用反射调用方法，使用MethodProxy
                //Object result = methodProxy.invoke(serviceImpl, args);
                return result;
            }
        });
        return serviceProxy;
    }
}
