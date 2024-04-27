package com.spring.transaction;


import org.springframework.context.ApplicationContext;

/*
    spring测试之一，事务失效
 */
public class T1 {
    public static void main(String[] args) {
        System.out.println("hello world");
        String str = "s";
        if (str.equals("ss")){
            System.out.println("no");
        }else {
            System.out.println("555");
        }
    }
}
