package com.design_mode.strategy;

import java.util.HashMap;

/**
 * @author cgh
 * @create 2023-02-23 13:43
 */
public class StrategyFactory {
    private static final HashMap<StrategyConstantsEnum,Strategy> strategyMap = new HashMap<>();
    static {
        strategyMap.put(StrategyConstantsEnum.ADDITION_STRATEGY,new AdditionStrategy());
        strategyMap.put(StrategyConstantsEnum.SUBTRACTION_STRATEGY,new SubtractionStrategy());
        strategyMap.put(StrategyConstantsEnum.DIVISION_STRATEGY,new DivisionStrategy());
    }

    public static Strategy getStrategy(StrategyConstantsEnum strategyType){
        return strategyMap.get(strategyType);
    }
}
