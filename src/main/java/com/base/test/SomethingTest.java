package com.base.test;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * @author cgh
 * @create 2022-06-28 15:52
 */
public class SomethingTest {
    public static void main(String[] args) {
        System.out.println("input");
        Scanner scanner = new Scanner(System.in);
        int[] array = {0,0,0,0,0,0,0,0,0,0};
        while (true) {
            int value = scanner.nextInt();
            if (value == -1) {
                break;
            }
            if (value >= 1 && value <= 100){
                //判断哪个下标
                array[(value-1)/10]++;
            }
        }
        scanner.close();
        for (int i = 0; i < 10; i++) {
            System.out.print(i * 10 + 1 + "-" + (i + 1) * 10 + "\t" + "|\t");
            for (int j = 0; j < array[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Test
    public void test() {
        String str = new String("需求分析-初级-20211001");
        int index = str.indexOf("-");
        System.out.println("- 下标为" + index);
        String reqName = str.substring(0, index);
        System.out.println(reqName);
    }

    @Test
    public void stringTest() {
        String dictCode = "sys_user,realname,id";
        if (dictCode.contains(",")) {
            //关联表字典（举例：sys_user,realname,id）
            String[] params = dictCode.split(",");
            System.out.println(Arrays.toString(params));
        }
    }

    @Test
    public void dateTest() {
        String date = "2022-12-31";
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            String startDate = new SimpleDateFormat("yyyy年MM月dd日").format(parse);
            System.out.println(startDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        /*String year = date.substring(0, date.indexOf("-"));
        String month = date.substring(5, date.indexOf("-",5));

        String day = date.substring(8);

        System.out.println(year);
        System.out.println(month);
        System.out.println(day);*/

    }


}
