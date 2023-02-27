package com.design_mode.strategy;

import java.util.HashMap;

/**
 * @author cgh
 * @create 2023-02-23 13:43
 * 策略工厂类，用于创建合适的策略。
 * 这里省去了用if,else这种判断，使用map代替了，更为简洁。
 */
public class StrategyFactory {
    private static final HashMap<StrategyConstantsEnum, Strategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put(StrategyConstantsEnum.ADDITION_STRATEGY, new AdditionStrategy());
        strategyMap.put(StrategyConstantsEnum.SUBTRACTION_STRATEGY, new SubtractionStrategy());
        strategyMap.put(StrategyConstantsEnum.DIVISION_STRATEGY, new DivisionStrategy());
    }

    //工厂对外暴露的get方法。
    public static Strategy getStrategy(StrategyConstantsEnum strategyType) {
        if (strategyType == null) {
            throw new RuntimeException("strategy should not be null!");
        }
        return strategyMap.get(strategyType);
    }
}
