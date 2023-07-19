package com.spring.aspectj.service.impl;

import com.spring.aspectj.service.QueryInfo;

/**
 * @author cgh
 * @create 2023-07-18
 */
public class QueryUserInfo implements QueryInfo {
    @Override
    public void query() {
        System.out.println("select * from user;");
    }

    @Override
    public void update() {
        System.out.println("update xxx set xxx...");
    }
}
