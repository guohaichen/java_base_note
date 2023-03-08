package com.base.entity;

import lombok.Data;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author cgh
 * @create 2023-03-06 10:35
 * 动态创建bean属性 测试
 */
@Data
public class DayBeanTest {
    private String first;
    private String second;
    private String third;

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        DayBeanTest dayBeanTest = new DayBeanTest();
        System.out.println(Arrays.toString(dayBeanTest.getClass().getDeclaredFields()));

        HashMap<String, Object> map = new HashMap<>();
        map.put("fourth", "4");
        map.put("fifth", "5");
        DayBeanTest object = (DayBeanTest) ReflectUtil.getObject(dayBeanTest, map);


        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }


    }
}
