package com.Algorithmic_thinking.lfu;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LFUCache extends LinkedHashMap<String, String> {
    private final int capacity;

    public LFUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
        //元素个数大于容量，删除元素，淘汰lfu数据
        return size() > capacity;
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(5);
        lfu.put("fist", "1");
        lfu.put("second", "2");
        lfu.put("third", "3");
        lfu.put("fourth", "4");
        lfu.put("fifth", "5");
        lfu.put("sixth", "6");
        Set<Map.Entry<String, String>> entries = lfu.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
