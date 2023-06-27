package com.spring.annotation;

/**
 * @author cgh
 * @create 2023-06-15
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException {
        Demo demo = new Demo("陈国海");
        System.out.println(demo.getName());

        ValueInjector.injectValue(demo);
        System.out.println(demo.getName());

    }
}
