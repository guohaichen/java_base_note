package com.代码随想录.leetcode;

import com.代码随想录.leetcode.baseStruct.ListNode;

/**
 * @author cgh
 * @create 2023-07-21
 * 删除链表的倒数第n个节点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 空间算法要求o1
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class LeetCode19 {
    public static void main(String[] args) {
        ListNode head = ListNode.getHead();
        ListNode listNode = ListNode.createListNode();
        System.out.println("之前: " + listNode);
        ListNode removeListNode = removeBackNode(head, 4);
        System.out.println("之后: " + removeListNode);
    }

    /*一次遍历，使用快慢指针，快指针先移动n，随后快慢指针一起移动，直到快指针指向null,这时慢指针指向的下一个节点为倒数的n个节点。
    假设一共10个节点（这里用临时节点指向head，所以逻辑上一共11个节点），删除倒数第3个节点，fastNode 先走3步，然后fastNode和slowNode一起走，
    fastNode走到next为空还有7步，这时slowNode走到了7,删除的节点为8;
    temp 1 2 3 4 5 6 7 8 9 10

     */
    public static ListNode removeBackNode(ListNode head, int n) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;

        ListNode fastNode = listNode;
        ListNode slowNode = listNode;
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        //删除元素
        slowNode.next = slowNode.next.next;

        //如果这里返回head，如果只有1个节点就会出错，删除该节点还是会返回head，
        return listNode.next;
    }
}
