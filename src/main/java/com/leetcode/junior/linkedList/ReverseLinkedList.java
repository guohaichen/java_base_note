package com.leetcode.junior.linkedList;

import java.util.LinkedList;

/**
 * @author cgh
 * @create 2022-08-24 22:05
 * 反转链表
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(null);
        selectNode(head);
    }

    //查询链表
    private static void selectNode(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp+"\t");
            temp = temp.next;
        }
    }


    //链表反转
    static LinkedList<Integer> reverse(LinkedList<Integer> head) {
        return null;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value + "}";
        }
    }
}





