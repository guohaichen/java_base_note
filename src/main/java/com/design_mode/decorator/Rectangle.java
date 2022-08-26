package com.design_mode.decorator;

/**
 * @author cgh
 * @create 2022-08-26 15:03
 * Rectangle 长方形类
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape : Rectangle");
    }
}
