package com.base.tree;

import com.Algorithmic_thinking.tree.BinaryTree;
import com.Algorithmic_thinking.tree.BinaryTree.TreeNode;

import java.util.LinkedList;

/**
 * @author cgh
 * @create 2024/5/6
 * 迭代法遍历二叉树的前置知识，结合栈打印出遍历二叉树的过程。
 * 二叉树采用如下
 * 思路：正常根-左-右；遍历的同时 压栈，随后当节点为空时，出栈。
 * 观察输出结果，入栈的结果是前序遍历，出栈的结果未中序遍历
 * 5
 * /     \
 * 4        6
 * /    \     /   \
 * 1      2   7     8
 */
public class PrintAllPath {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = tree.getRoot();

        TreeNode pop = null; //最近一次弹栈的节点
        while (current != null || !stack.isEmpty()) {
            //当current == null时，遍历完左子树
            if (current != null) {
                stack.push(current); //压栈，为了记住来时的路
                System.out.println("入栈:\t" + current.val);//前序遍历
                current = current.leftNode;
            } else {
                TreeNode peek = stack.peek();
                // pop == peek.rightNode 看是否已处理过，例如4的右节点2，栈中为 5，4，2。
                // 这时2出栈，该处理4时，发现4的rightNode不等于空，所以会进入到else，2又会变成current进栈。会进入死循环。
                // 如果有 pop == peek.rightNode
                if (peek.rightNode == null || pop == peek.rightNode) {
                    pop = stack.pop();
                    System.out.println("出栈:\t\t" + pop.val);  //后序遍历
                } else {
                    current = peek.rightNode;
                }
            }
        }
    }
}
