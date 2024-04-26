package com.base.stack.impl.unitTest;

import com.base.stack.impl.ArrayStack;
import com.base.stack.impl.ListNodeStack;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @author cgh
 * @create 2024/4/25
 */
public class StackTest {

    @Test
    public void ListNodeStack() {
        ListNodeStack<Integer> stack = new ListNodeStack<>(5);
        System.out.println("isEmpty:\t" + stack.isEmpty());
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(9);
        System.out.println("isFull:\t" + stack.isFull());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("push 6 result:\t" + stack.push(6));
        System.out.println("stack.size:\t" + stack.getSize());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
    }

    @Test
    public void ArrayStack(){
        ArrayStack<Integer> stack = new ArrayStack<>(4);
        System.out.println("stack is empty:\t"+stack.isEmpty());
        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.push(6);
        System.out.println("stack is full:\t"+stack.isFull());

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.getTopIndex());

    }

    @Test
    public void ListNode(){
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(6);
        stack.push(5);
        stack.push(4);
        System.out.println(stack.poll());
        System.out.println(stack.pop());
    }

}
