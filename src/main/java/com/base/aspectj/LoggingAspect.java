package com.base.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author cgh
 * @create 2023-07-18
 * 模拟一个日志切面，
 */
@Aspect
public class LoggingAspect {
    //定义切点，只增强query方法，这里具体看切点表达式
    @Pointcut("execution(* query(..))")
    public void queryMethod() {
    }

//    前置通知，在目标方法执行之前执行
    @Before("queryMethod()")
    public void beforeAdvice() {
        System.out.println("LoggingAspect before;");
    }

    @Around("queryMethod()")
    public Object afterAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("LoggingAspect around start");
        //使用around需要显示调用proceed方法
        Object proceed = joinPoint.proceed();
        System.out.println("LoggingAspect around end");
        return proceed;
    }
}
