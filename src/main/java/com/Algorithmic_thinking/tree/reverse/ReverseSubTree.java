package com.Algorithmic_thinking.tree.reverse;

import com.Algorithmic_thinking.tree.BinaryTree;
import com.Algorithmic_thinking.tree.query.BinaryTreeQuery;

/**
 * @author cgh
 * @create 2023-07-17
 * leetcode226 反转二叉树
 * 之前：
 *           5
 *       /     \
 *     4        6
 *   /   \     /   \
 * 1      2   7     8
 */
public class ReverseSubTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        reverseTree(tree.getRoot());
        //前序遍历验证结果
        System.out.println(BinaryTreeQuery.preorder(tree.getRoot()));
    }

    public static void reverseTree(BinaryTree.TreeNode root) {
        if (root == null) {
            return;
        }
        //注意 这里使用的是前序遍历
        swap(root);
        reverseTree(root.leftNode);
        reverseTree(root.rightNode);
    }

    //根据 根节点对左右节点进行翻转
    private static void swap(BinaryTree.TreeNode root) {
        BinaryTree.TreeNode tempNode = root.leftNode;
        root.leftNode = root.rightNode;
        root.rightNode = tempNode;
        //可以验证输出中序遍历方式的错误翻转，会出现多余翻转次数
        if (root.leftNode != null && tempNode != null){
            System.out.println(root.leftNode.val+" <-----------  swap -----------> " + tempNode.val);
        }
    }
}
