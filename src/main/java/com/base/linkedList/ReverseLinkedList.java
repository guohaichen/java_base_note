package com.base.linkedList;

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
        Node node = recursionReserve(head);
        System.out.println();
        System.out.println("反转后:");
        selectNode(node);
    }

    //查询链表
    private static void selectNode(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp);
            temp = temp.next;
        }
    }

    //链表反转，双指针法
    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            //1->2->3
            //3->2->1
            //temp 临时变量，如 1->2->3 ，要改变 2->1,需要先将 2->3 这个指针保存下来，不然就找不到了。
            Node temp = curr.next;
            // 将 2 指向 1；
            curr.next = prev;
            //pre.cur指针后移， pre1 cur2 temp3
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    //构造新的链表，头插法返回 新链表即翻转链表
    static Node headReverse(Node node) {
        Node head = null;
        Node n1 = node;
        while (n1 != null) {

            //头插
            head = new Node(n1.value, head);

            // 指针后移
            n1 = n1.next;
        }
        return head;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
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

    //递归反转
    static Node recursionReserve(Node node) {
        while (node == null || node.next == null) {
            //返回最后的节点
            return node;
        }
        Node last = recursionReserve(node.next);
        // 使4-3
        node.next.next = node;
        //节点3本来指向4,经过上一步反转后4-3，需要将3指向null，否则就构成了环
        node.next = null;
        return last;
    }



}





