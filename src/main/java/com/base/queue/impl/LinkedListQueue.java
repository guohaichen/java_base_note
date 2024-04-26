package com.base.queue.impl;

import com.base.queue.MyQueue;

/**
 * @author cgh
 * @create 2024/4/19
 * 单链表实现
 * todo
 */
public class LinkedListQueue<E> implements MyQueue<E> {

    static class Node<E> {
        E value;
        Node<E> next;
    }


    @Override
    public boolean offer(E value) {




        return true;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
