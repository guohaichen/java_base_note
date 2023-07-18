package com.base.aspectj;

import com.base.aspectj.service.impl.QueryUserInfo;

/**
 * @author cgh
 * @create 2023-07-18
 * 这里使用的是ajc编译器, aspectj-maven-plugin，用于编译器修改class实现增强;
 * 修改后需要使用maven的重新编译，而不能使用idea的javac；
 */
public class AjcDriver {
    public static void main(String[] args) {
        QueryUserInfo queryUserInfo = new QueryUserInfo();
        //调用query方法，发现还是被增强了，
        queryUserInfo.query();
        queryUserInfo.update();
        /*验证queryUserInfo并不是代理类，查看class文件,如下，说明是在编译器就被修改了。
        JoinPoint var1 = Factory.makeJP(ajc$tjp_0, this, this);
        LoggingAspect.aspectOf().beforeAdvice(var1);
        System.out.println("select * from user;");
         */
//        System.out.println(queryUserInfo.getClass());
    }
}
