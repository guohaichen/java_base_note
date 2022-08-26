package com.design_mode.decorator;

/**
 * @author cgh
 * @create 2022-08-26 15:21
 * 意图：动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相比生成子类更为灵活。
 * 主要解决：一般的，我们为了扩展一个类经常使用继承方式实现，由于继承为类引入静态特征，并且随着扩展功能的增多，子类会很膨胀。
 * 何时使用：在不想增加很多子类的情况下扩展类。
 * 如何解决：将具体功能职责划分，同时继承装饰者模式。
 * 关键代码： 1、Component 类充当抽象角色，不应该具体实现。 2、修饰类引用和继承 Component 类，具体扩展类重写父类方法。
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Shape circle = new Circle();
        RedShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        RedShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());

        SizeRedShapeDecorator sizeRedShapeDecorator = new SizeRedShapeDecorator(redRectangle);

        //默认
        circle.draw();
        System.out.println("=================");
        //第一层 装饰器后的
        redCircle.draw();
        redRectangle.draw();
        System.out.println("=================");
        //第二层 装饰器后的
        sizeRedShapeDecorator.draw();
    }
}
