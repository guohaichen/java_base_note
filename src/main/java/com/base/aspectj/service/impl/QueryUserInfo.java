package com.base.aspectj.service.impl;

import com.base.aspectj.service.QueryInfo;
import org.springframework.stereotype.Service;

/**
 * @author cgh
 * @create 2023-07-18
 */
@Service
public class QueryUserInfo implements QueryInfo {
    @Override
    public void query() {
        System.out.println("select * from user;");
    }
}
