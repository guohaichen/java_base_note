package com.base.annotation;

import java.lang.reflect.InvocationTargetException;

/**
 * @author cgh
 * @create 2022-09-13 10:39
 */
public class AnnotationTest {
    @MyAutowired
    private Animal animal;

    public AnnotationTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        AutowiredInject.inject(animal);
    }

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        AnnotationTest test = new AnnotationTest();
        test.animal.say();
    }
}
