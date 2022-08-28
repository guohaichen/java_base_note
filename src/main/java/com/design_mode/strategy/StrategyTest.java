package com.design_mode.strategy;

/**
 * @author cgh
 * @create 2022-08-28 16:46
 * 测试
 */
public class StrategyTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new AdditionStrategy());
        System.out.println(calculator.executeStrategy(1, 2));

        //set方法改变策略；
        calculator.setStrategy(new DivisionStrategy());
        System.out.println( calculator.executeStrategy(12, 2));
    }
}
