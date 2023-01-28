package com.base.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author cgh
 * @create 2022-09-13 10:27
 */
public class AutowiredInject {
    public static void inject(Object object) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            //标记了MyAutowired注解的字段
            if (field.getAnnotation(MyAutowired.class)!=null){
                inject(object,field);
            }
        }
    }

    private static void inject(Object target, Field field) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> fieldClass = field.getType();
        Object fieldObject = fieldClass.getConstructor().newInstance();
        field.setAccessible(true);
        field.set(target,fieldObject);
    }
}
