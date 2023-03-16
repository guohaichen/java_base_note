package com.base.stream.entity;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {
    private Integer Id;

    private String month;

    private Integer workHours;

    public User(Integer id, String month, Integer workHours) {
        Id = id;
        this.month = month;
        this.workHours = workHours;

    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", month='" + month + '\'' +
                ", workHours=" + workHours +
                '}';
    }

    public static List<User> getList() {
        List<User> userArrayList = new ArrayList<>();
        userArrayList.add(new User(1001, "2021-10", 6));
        userArrayList.add(new User(2001, "2021-09", 8));
        userArrayList.add(new User(2001, "2021-10", 7));
        userArrayList.add(new User(1001, "2021-09", 8));
        userArrayList.add(new User(3001, "2021-10", 8));
        userArrayList.add(new User(1001, "2021-11", 8));
        userArrayList.add(new User(3001, "2021-09", 6));
        return userArrayList;
    }

}
