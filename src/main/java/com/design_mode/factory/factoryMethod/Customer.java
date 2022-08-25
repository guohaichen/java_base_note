package com.design_mode.factory.factoryMethod;

/**
 * @author cgh
 * @create 2022-08-25 11:26
 *  * 工厂方法模式，和简单工厂模式的区别在于 工厂方法模式只定义工厂接口，具体实现交给 各自的工厂实现类；
 */
public class Customer {
    public static void main(String[] args) {
        CoffeeFactory luckinFactory = new LuckinFactory();
        luckinFactory.makeCoffee();

        CoffeeFactory starbucksFactory = new StarbucksFactory();
        starbucksFactory.makeCoffee();
    }
}
