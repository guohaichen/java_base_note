package com.Algorithmic_thinking.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cgh
 * @create 2023-06-30
 * 页面置换算法 LRU least Recently use 最近最久未使用
 * 这里使用hashMap+双向链表实现
 * 在设计一个lru时，需要考虑：
 * 1. 缓存容量大小
 * 2. 缓存命中率，考虑如何最大化命中率，将最近使用的放在链表头，淘汰链表尾部等
 * 3. 缓存淘汰策略，在缓存容量不足时，需要考虑选择最久未使用的数据进行淘汰。
 * 4. 并发安全等；
 * <p>
 * 这里用了LinkedHashMap也可以达到lfu的效果，自定义一个类继承LinkedHashMap，通过构造使他插入有序，并重写可以删除元素的方法；
 */
class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, Node> cache;
    private final Node head;
    private final Node tail;

    class Node {
        K key;
        V value;
        Node prev;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(null, null);
        this.tail = new Node(null, null);
        this.head.next = tail;
        this.tail.prev = head;
    }

    public V get(K key) {
        Node node = cache.get(key);
        if (node != null) {
            // 将访问的节点移动到链表头部
            moveToHead(node);
            return node.value;
        }
        return null;
    }

    public void put(K key, V value) {
        Node node = cache.get(key);
        if (node != null) {
            // 更新节点的值，并将节点移动到链表头部
            node.value = value;
            moveToHead(node);
        } else {
            if (cache.size() >= capacity) {
                // 移除最久未使用的节点（链表尾部）
                Node removed = removeTail();
                cache.remove(removed.key);
            }
            // 创建新节点，并将节点插入链表头部
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private Node removeTail() {
        Node removed = tail.prev;
        removeNode(removed);
        return removed;
    }

    public static void main(String[] args) {
        LRUCache<String, String> lruCache = new LRUCache<>(5);
        lruCache.put("fist", "1");
        lruCache.put("second", "2");
        lruCache.put("third", "3");
        lruCache.put("fourth", "4");
        lruCache.put("fifth", "5");
        lruCache.put("sixth", "6");
        //测试发现已淘汰最近最久未使用的
        for (Map.Entry<String, LRUCache<String, String>.Node> stringNodeEntry : lruCache.cache.entrySet()) {
            System.out.println(stringNodeEntry.getKey() + ":" + lruCache.get(stringNodeEntry.getKey()));
        }
    }
}
