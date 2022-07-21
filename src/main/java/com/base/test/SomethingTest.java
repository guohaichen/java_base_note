package com.base.test;

import org.junit.Test;

/**
 * @author cgh
 * @create 2022-06-28 15:52
 */
public class SomethingTest {
    @Test
    public void test(){
        String str = new String("事假10-14 09:00到10-14 13:30 0.5天");
        int index = str.indexOf("事假");
        System.out.println("事假下标"+index);

        String substring = str.substring(index, index + 25);
        int time = substring.indexOf(":");

        System.out.println(":下标"+time);



        String substring1 = substring.substring(time - 2, time + 3);


        System.out.println(substring1);


    }
}
