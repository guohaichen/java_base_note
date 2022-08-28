package com.design_mode.strategy;

/**
 * @author cgh
 * @create 2022-08-28 16:13
 * 加法策略
 */
public class AdditionStrategy implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        return a + b;
    }
}
