package com.design_mode.proxy;


/**
 * @author cgh
 * @create 2022-06-17 9:22
 * 静态代理实现步骤：
 * 1. 定义一个接口及其实现类
 * 2. 创建一个代理类同样实现这个接口
 * 3. 将目标对象注入代理类，然后在代理类的对应方法调用目标类中的对应方法
 */
//1.1 定义接口，这里用StaticProxy代理ServiceImpl中的print方法
public interface Service {
    void print(String message);
}





