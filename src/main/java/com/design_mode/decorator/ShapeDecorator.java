package com.design_mode.decorator;

/**
 * @author cgh
 * @create 2022-08-26 15:05
 * 实现Shape接口的抽象装饰类
 *      后续的包装类只需要继承这个抽象类，然后再在其中加入新的行为和属性就可以了，而不需要重复封装。
 */
public abstract class ShapeDecorator implements Shape{


    protected Shape decoratedShape;


    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
