package com.base.stack.impl;

import com.base.stack.MyStack;
import lombok.Getter;


/**
 * @author cgh
 * @create 2024/4/25
 * 数组实现栈，注意栈顶下标的运算即可，push之后要将栈顶下标自增，pop要先自减，peek则是栈顶下标-1
 */
public class ArrayStack<E> implements MyStack<E> {

    private final E[] array;

    //用来指向栈顶元素,存放元素从0->index
    @Getter
    private int topIndex = 0;

    @SuppressWarnings("unchecked cast")
    public ArrayStack(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        array[topIndex++] = value;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return array[--topIndex];
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[topIndex - 1];
    }

    @Override
    public boolean isEmpty() {
        return topIndex == 0;
    }

    @Override
    public boolean isFull() {
        return topIndex == array.length;
    }
}
