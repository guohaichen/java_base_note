package com.Algorithmic_thinking.annotation;

import java.lang.reflect.Field;

/**
 * @author cgh
 * @create 2023-06-15
 * 注解注入类，在spring中，加上@component将该 类交给spring容器管理，就可以实现属性的自动注入；
 */
public class ValueInjector {
    public static void injectValue(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(PrefixName.class)) {
                PrefixName annotation = field.getAnnotation(PrefixName.class);
                String prefix = annotation.prefix();
                //开启 可以通过反射获得该字段
                field.setAccessible(true);
                //设置值
                field.set(object, prefix + field.get(object));
            }
        }
    }
}
