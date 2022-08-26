package com.design_mode.decorator;

/**
 * @author cgh
 * @create 2022-08-26 15:08
 * 第二层装饰:对ShapeDecorator装饰了一个行为;
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println(decoratedShape.getClass().getName() + "Border color : red");
    }

}
