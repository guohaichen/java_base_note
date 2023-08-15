package com.Algorithmic_thinking.tree;

/**
 * @author cgh
 * @create 2023-07-14
 * 定义了二叉树结构，构造函数构建了如下二叉树，为其他二叉树查询提供结构；
 *           5
 *        /     \
 *      4        6
 *   /   \     /   \
 * 1      2   7     8
 */
public class BinaryTree {
    private final TreeNode root;

    public static class TreeNode {
        public int val;
        public TreeNode leftNode;
        public TreeNode rightNode;

        public TreeNode(int val) {
            this.val = val;
            leftNode = null;
            rightNode = null;
        }
    }

    //构建一个二叉树
    public BinaryTree() {
        root = new TreeNode(5);
        //左子树
        TreeNode node4 = new TreeNode(4);
        root.leftNode = node4;
        node4.leftNode = new TreeNode(1);
        node4.rightNode = new TreeNode(2);
        //右子树
        TreeNode node6 = new TreeNode(6);
        root.rightNode = node6;
        node6.leftNode = new TreeNode(7);
        node6.rightNode = new TreeNode(8);
    }

    public TreeNode getRoot() {
        return root;
    }

    //求树的最大高度
    public int getMaxHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int max = 0;
        int maxL = 0;
        int maxR = 0;
        if (node.leftNode != null) {
            maxL = getMaxHeight(node.leftNode);
        }
        if (node.rightNode != null) {
            maxR = getMaxHeight(node.rightNode);
        }
        max = maxL > maxR ? maxL + 1 : maxR + 1;
        return max;
    }
}
