package com.design_mode.factory.factoryMethod;

import com.design_mode.factory.Starbucks;

/**
 * @author cgh
 * @create 2022-08-25 11:26
 */
public class StarbucksFactory implements CoffeeFactory{
    @Override
    public void makeCoffee() {
        new Starbucks();
    }
}
