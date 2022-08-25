package com.design_mode.simpleFactory;

/**
 * @author cgh
 * @create 2022-08-25 9:07
 */
public class Starbucks extends Coffee {

    public Starbucks() {
        System.out.println("starbucks");
    }

    @Override
    public void addCoffBean() {
        System.out.println("哥伦比亚咖啡豆");
    }

    @Override
    public void addSugar() {
        System.out.println("加菲糖");
    }

    @Override
    public void addMilk() {
        System.out.println("全脂牛奶");
    }
}
