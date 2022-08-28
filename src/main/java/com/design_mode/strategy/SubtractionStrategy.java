package com.design_mode.strategy;

/**
 * @author cgh
 * @create 2022-08-28 16:15
 * 减法策略模式
 */
public class SubtractionStrategy implements Strategy{
    @Override
    public int doOperation(int a, int b) {
        return a - b;
    }
}
