package com.design_mode.proxy.cglibProxy;

import com.base.spring.proxy.base.Service;
import com.base.spring.proxy.base.ServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author cgh
 * @create 2022-06-18 14:11
 * cglib动态代理，使用cglib包下的Enhancer.create（）
 * cglib 不要求目标实现接口，它生成的代理类是目标的子类，因此代理与目标之间是子父关系
 */
public class CglibProxyDemo {
    public static void main(String[] param) {
        ServiceImpl service = new ServiceImpl();

        Service serviceProxy = (Service) Enhancer.create(service.getClass(), new MethodInterceptor() {
            //Object[] args 为方法参数
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib before");
                //反射调用方法
                Object result = method.invoke(service, args);
                //cglib可以避免使用反射调用方法，使用MethodProxy
//                Object result = methodProxy.invoke(service, args);

                System.out.println("cglib after");
                return result;
            }
        });
        serviceProxy.print("cglib");
    }
}
