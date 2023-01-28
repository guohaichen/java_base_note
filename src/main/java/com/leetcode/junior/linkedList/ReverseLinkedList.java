package com.leetcode.junior.linkedList;

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
        selectNode(head);
        reverse(head);
        System.out.println();
        System.out.println("反转后:");
        selectNode(node3);
    }
    //查询链表
    private static void selectNode(Node head) {
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp);
            temp = temp.next;
        }
    }
    //链表反转
    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            //node的next指向node，但是需要将node的next保存下来，如果辅助了就找不到整个链表了
            //1->2->3
            //3->2->1
            Node next =curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value + "}  ";
        }
    }
}





