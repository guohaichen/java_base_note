package com.base.backtracking;

import java.util.LinkedList;

/**
 * @author cgh
 * @create 2024/5/21
 * 认识回溯算法
 */
public class BackTracing {
    public static void main(String[] args) {
        rec(1, new LinkedList<>());
    }

    private static void rec(int i, LinkedList<String> list) {
        if (i == 3) {
            return;
        }
        System.out.println("before" + list);
        list.push("a");
        rec(i + 1, list);
        //当i==3 return时 会执行到下面的语句
        list.pop();
        System.out.println("\t after" + list);
    }

}
