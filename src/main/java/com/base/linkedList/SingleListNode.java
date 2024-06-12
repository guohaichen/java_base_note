package com.base.linkedList;

/**
 * @author cgh
 * @create 2024/4/19
 * 实现单链表
 */
public class SingleListNode<E> {
    static class Node<E> {
        Node<E> next;
        E value;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    Node<E> head;

    //增删改查，基本操作
    public Boolean add(E value) {
        //头插法,将新节点作为头，原来的头 成为新节点得next;
        this.head = (new Node<>(value, this.head));
        return true;
    }


    public void select() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.print(temp.value + "\t");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SingleListNode singleListNode = new SingleListNode();
        singleListNode.add(7);
        singleListNode.add(5);
        singleListNode.add(3);
        singleListNode.add(1);
//        listNode
        singleListNode.select();
        singleListNode.remove(3);
        singleListNode.select();
    }

    /**
     * 根据下标删除元素
     *
     * @param index 下标
     */
    private void remove(int index) {
        //1 - 3 - 5 - 7
        int i = 1;
        if (head == null) {
            return;
        }
        if (index == 1) {
            head = head.next;
            return;
        }
        Node<E> current = head;
        while (current.next != null && i < index - 1) {
            current = current.next;
            i++;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

}
