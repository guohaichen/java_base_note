package com.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author cgh
 * @create 2023-06-15
 * 注解，作用在属性上，用于替换值；
 */
//运行时使用
@Retention(RetentionPolicy.RUNTIME)
//注解作用于
@Target(ElementType.FIELD)
public @interface PrefixName {
    String prefix();
}
