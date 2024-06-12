package com.base.queue;

import java.util.LinkedList;

/**
 * @author cgh
 * @create 2024/5/30
 * 单调递减队列 见readme
 * 队头到队尾的元素是从大到小排列，如果有新的元素入队，如果比队尾元素小则入队，大的话则依旧比较
 */
public class MonotonicDecreaseQueue {
    private final LinkedList<Integer> deque = new LinkedList<>();

    public void offer(Integer num) {
        while (!deque.isEmpty() && deque.peekLast() < num) {
            deque.pollLast();
        }
        deque.offerLast(num);
    }

    @Override
    public String toString() {
        return deque.toString();
    }

    public void poll() {
        deque.pollFirst();
    }

    public static void main(String[] args) {
        MonotonicDecreaseQueue queue = new MonotonicDecreaseQueue();
        for (int i : new int[]{1, 3, -1, -3, 5, 3, 6, 7}) {
            queue.offer(i);
            System.out.println(queue);
        }
    }
}
