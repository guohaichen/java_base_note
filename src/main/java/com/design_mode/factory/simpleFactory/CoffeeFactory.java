package com.design_mode.factory.simpleFactory;

import com.design_mode.factory.Coffee;
import com.design_mode.factory.Starbucks;
import com.design_mode.factory.Luckin;

/**
 * @author cgh
 * @create 2022-08-25 9:14
 * 简单工厂结构：
 * - 抽象产品类， Coffee
 * - 具体类， 继承抽象产品类，Luckin,Starbucks
 * - 具体工厂类，对外提供创建具体产品的方法
 */
public class CoffeeFactory {
    public static Coffee makeCoffee(String coffeeName) {
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
        Coffee luckin = CoffeeFactory.makeCoffee("luckin");
        System.out.println("-----------------------");
        Coffee starbucks = CoffeeFactory.makeCoffee("starbucks");
    }
}