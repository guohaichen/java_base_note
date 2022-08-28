package com.design_mode.strategy;

/**
 * @author cgh
 * @create 2022-08-28 16:21
 * 使用了Strategy的类，具体要做什么操作，交给调用者
 */
public class Calculator {
    private Strategy strategy;

    public Calculator(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    //定义执行策略模式的方法，doOperation具体实现根据Calculator类传进来的策略实现类
    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }

}
