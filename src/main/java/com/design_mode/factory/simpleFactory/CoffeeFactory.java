package com.design_mode.factory.simpleFactory;

import com.design_mode.factory.Coffee;
import com.design_mode.factory.Luckin;
import com.design_mode.factory.Starbucks;

import java.util.HashMap;

/**
 * @author cgh
 * @create 2022-08-25 9:14
 * 简单工厂结构：
 * - 抽象产品类， Coffee
 * - 具体类， 继承抽象产品类，Luckin,Starbucks
 * - 具体工厂类，对外提供创建具体产品的方法
 */
public class CoffeeFactory {
    //简单工厂实现方式一：
//    public static Coffee createCoffee(String coffeeName) {
//        if ("luckin".equals(coffeeName)) {
//            return new Luckin();
//        } else if ("starbucks".equals(coffeeName)) {
//            return new Starbucks();
//        } else {
//            throw new RuntimeException("no coffee");
//        }
//    }
    //简单工厂实现方式二：配合懒汉式单例和简单工厂
    private final static HashMap<String, Coffee> coffeeMap = new HashMap<>();
    static {
        coffeeMap.put("luckin",new Luckin());
        coffeeMap.put("starbucks",new Starbucks());
    }
    public static Coffee createCoffee(String coffee){
        if (coffee==null || coffee.isEmpty()){
            return null;
        }
        return coffeeMap.get(coffee.toLowerCase());
    }
}

class Customer {
    public static void main(String[] args) {
        Coffee luckin = CoffeeFactory.createCoffee("luckin");
        System.out.println("-----------------------");
        Coffee starbucks = CoffeeFactory.createCoffee("starbucks");
        System.out.println("------------------------");
        Coffee tims = CoffeeFactory.createCoffee("Tims");
    }
}