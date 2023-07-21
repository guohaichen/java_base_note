package com.代码随想录.leetcode.baseStruct;

/**
 * @author cgh
 * @create 2023-07-21
 * 定义单链表结构，方便刷题
 */
public class ListNode {
    private int val;
    public ListNode next;
    public static ListNode head = new ListNode(5);

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode createListNode() {

        head.next = new ListNode(1, new ListNode(4, new ListNode(8, new ListNode(9, new ListNode(3)))));
        return head;
    }

    public static ListNode getHead() {
        return head;
    }

    @Override
    public String toString() {
        return val + "->" + next;
    }

    public static void main(String[] args) {
        System.out.println(createListNode());
    }
}

