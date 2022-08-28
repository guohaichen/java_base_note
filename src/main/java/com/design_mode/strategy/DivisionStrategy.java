package com.design_mode.strategy;

/**
 * @author cgh
 * @create 2022-08-28 16:17
 * 除法策略
 */
public class DivisionStrategy implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        if (a == 0) {
            throw new RuntimeException("参数异常,被除数不能为0");
        }
        return a / b;
    }
}
