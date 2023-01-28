package com.base.date;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author cgh
 * @create 2022-09-23 14:22
 */
public class LocalDateTest {
    public static void main(String[] args) {
//        getDate();
//        getTime();
        getIns();
    }

    private static void getTime() {
        //获取当前时间
        LocalTime now = LocalTime.now();
        System.out.println(now);
    }

    private static void getIns(){
        Instant now = Instant.now();
        System.out.println(now);
    }


    private static void getDate() {
        //1.date与localDate的区别
        LocalDate today = LocalDate.now();
        System.out.println("today is " + today);
        int dayOfMonth = today.getDayOfMonth();
        int dayOfYear = today.getDayOfYear();
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        System.out.printf("今天是一个月当中的第%d天,是一年中的第%d天,今天是"+dayOfWeek, dayOfMonth, dayOfYear);
    }
}
