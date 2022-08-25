package com.design_mode.simpleFactory;

/**
 * @author cgh
 * @create 2022-08-25 9:14
 */
public class CoffeeFactory {
    public static Coffee createCoffee(String coffeeName) {
        if ("luckin".equals(coffeeName)) {
            return new Luckin();
        } else if ("starbucks".equals(coffeeName)) {
            return new Starbucks();
        } else {
            throw new RuntimeException("no coffee");
        }
    }
}

class Customer {
    public static void main(String[] args) {
        Coffee luckin = CoffeeFactory.createCoffee("luckin");
        luckin.addCoffBean();
        luckin.addMilk();
        luckin.addSugar();
        System.out.println("-----------------------");
        Coffee starbucks = CoffeeFactory.createCoffee("starbucks");
        starbucks.addCoffBean();
        starbucks.addMilk();
        starbucks.addSugar();
    }
}