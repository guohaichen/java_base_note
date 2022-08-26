package com.design_mode.decorator;

/**
 * @author cgh
 * @create 2022-08-26 17:19
 * 第三层装饰类
 */
public class SizeRedShapeDecorator extends RedShapeDecorator{
    public SizeRedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setSizeShape(decoratedShape);
    }


    private void setSizeShape(Shape decoratorShape){
        System.out.println(decoratorShape.getClass().getName()+" size : large!");
    }
}
