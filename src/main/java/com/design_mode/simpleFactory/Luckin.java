package com.design_mode.simpleFactory;

/**
 * @author cgh
 * @create 2022-08-25 9:07
 */
public class Luckin extends Coffee{

    public Luckin() {
        System.out.println("luckin coffee");
    }

    @Override
    public void addCoffBean() {
        System.out.println("埃塞俄比亚咖啡豆");
    }

    @Override
    public void addSugar() {
        System.out.println("生椰糖浆");
    }

    @Override
    public void addMilk() {
        System.out.println("奶盖");
    }
}
