package com.base.queue.impl;

import com.base.queue.MyQueue;

/**
 * @author cgh
 * @create 2024/4/23
 * 环形数组实现队列
 * 注意的点就是 环形数组，在计算下标时，假设当前下标为3，数组大小为5，向前走3步，正确的下标插入位置为1，公式为 （index+step）% size = 6%5 = 1
 * 数组的容量和环形队列大小不一致，环形队列+1 = 数组的容量，留个位置给tail。这里主要看 isEmpty 和 isFull 方法内的公式，可以得出；
 */
public class CycleArrayQueue1<E> implements MyQueue<E> {

    private final E[] array;
    private int tail = 0;
    private int head = 0;

    /*
    这里创建数组的时候，数组长度 = 容量+1，tail指向这个位置，因为在下面判空的方法isEmpty为 tail == head;所以tail专门留了一个位置；
     */
    @SuppressWarnings("unchecked")
    public CycleArrayQueue1(int capacity) {
        array = ((E[]) new Object[capacity + 1]);
    }

    @Override
    public boolean offer(E value) {
        //这里设计的是环形队列满之后 拒绝策略
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E newHead = array[head];
        head = (head + 1) % array.length;
        return newHead;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return tail == head;
    }

    @Override
    public boolean isFull() {
        return head == (tail + 1) % array.length;
    }

    @Override
    public int size() {
        return 0;
    }
}
