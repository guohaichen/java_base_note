package com.代码随想录.stackAndQueue;

import java.util.Stack;

/**
 * @author cgh
 * @create 2024-01-03
 * @desc leetcode232 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 */
public class Leetcode232 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(5);
        myQueue.push(7);
        System.out.println(myQueue.pop());
        myQueue.push(8);
        myQueue.push(8);
        System.out.println(myQueue.peek());
        myQueue.push(9);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.empty());
    }
}

class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;


    public MyQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            loadElementFromInStack();
        }
        return outStack.pop();
    }


    public int peek() {
        if (outStack.isEmpty()) {
            loadElementFromInStack();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void loadElementFromInStack() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}

