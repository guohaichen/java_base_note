package com.design_mode.factory.factoryMethod;

import com.design_mode.factory.Luckin;

/**
 * @author cgh
 * @create 2022-08-25 11:10
 */
public class LuckinFactory implements CoffeeFactory {
    @Override
    public void makeCoffee() {
        new Luckin();
    }
}
