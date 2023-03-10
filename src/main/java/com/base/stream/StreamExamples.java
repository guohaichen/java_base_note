package com.base.stream;

import com.base.stream.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamExamples {
    public static void main(String[] args) {
        List<User> list = User.getList();

        Map<Integer, Map<String, Integer>> kv = list.stream().collect(
                Collectors.groupingBy(User::getId, Collectors.toMap(User::getMonth, User::getWorkHours)));
        System.out.println(kv);
    }
}
