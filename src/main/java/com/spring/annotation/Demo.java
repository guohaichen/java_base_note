package com.spring.annotation;

/**
 * @author cgh
 * @create 2023-06-15
 * 注解,
 * 注解的作用由valueInjector实现
 */
public class Demo {
    @PrefixName(prefix = "业务开发_")
    private String name;

    public Demo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
