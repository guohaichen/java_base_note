package com.base.stack.impl;

import com.base.stack.MyStack;
import lombok.Getter;

/**
 * @author cgh
 * @create 2024/4/24
 * 栈通过单链表实现，栈的特性 先进后出，这里有一个哨兵节点head，head指向每次新插入的元素，新插入的元素指向 原来head.next。
 * 栈空可以通过 head.next是否为空来判断，也可以通过size大小来判断，栈满则判断 size==栈容量
 */
public class ListNodeStack<E> implements MyStack<E> {
    static class Node<E> {
        Node<E> next;
        E value;

        public Node(E value, Node<E> next) {
            this.next = next;
            this.value = value;
        }

        public Node(E value) {
            this.value = value;
        }
    }

    private final Node<E> head = new Node<>(null, null);
    //栈内元素大小
    @Getter
    private int size;
    private final int capacity;

    public ListNodeStack(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        head.next = new Node<>(value, head.next);
        size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        size--;
        Node<E> firstNode = head.next;
        head.next = firstNode.next;
        return firstNode.value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        size--;
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }
}
