package com.base.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author cgh
 * @create 2023-07-18
 * 模拟一个日志切面，
 */
@Aspect
public class LoggingAspect {
    //定义切点，匹配所有方法
    @Pointcut("execution(* *(..))")
    public void anyPublicMethod() {
    }

    //前置通知，在目标方法执行之前执行
    @Before("anyPublicMethod()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("before method: " + joinPoint.getSignature().getName());
    }

    @After("anyPublicMethod()")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("after method" + joinPoint.getSignature().getName());
    }

}
