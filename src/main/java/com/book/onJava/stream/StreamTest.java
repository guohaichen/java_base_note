package com.book.onJava.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cgh
 * @create 2022-07-10 20:01
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        //创建流 1. stream 2.parallelStream
        //去掉空串，并toList
        List<String> strings = stringList.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        //统计长度为3的数量
        long count = stringList.stream().filter(string -> string.length() == 3).count();
        System.out.println("字符串list长度为3的数量是"+count);


        for (String string : strings) {
            System.out.println(string);
        }
    }
}
