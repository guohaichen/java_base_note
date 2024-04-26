package com.base.queue.impl.unitTest;

import com.base.queue.MyQueue;

import java.util.Stack;

/**
 * @author cgh
 * @create 2024/4/26
 * 力扣232 使用两个栈实现队列
 * 栈： 先进后出
 * 队列： 先进先出
 * 队列 1 - 3 - 5 - 7
 * <p>
 * InStack :  7 5 3 1 再压入OutStack 变为 1 3 5 7
 */
public class DoubleStackQueue<E> implements MyQueue<E> {

    //入栈
    private final Stack<E> stackIn;
    //队列出口
    private final Stack<E> stackOut;

    private final int capacity;

    public DoubleStackQueue(int capacity) {
        this.capacity = capacity;
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        stackIn.push(value);
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }

    @Override
    public boolean isEmpty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    @Override
    public boolean isFull() {
        int size = stackIn.size() + stackOut.size();
        return size == capacity;
    }

    @Override
    public int size() {
        return stackIn.size() + stackOut.size();
    }
}
