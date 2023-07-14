package com.Algorithmic_thinking.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cgh
 * @create 2023-07-14
 * 二叉树的前中后序遍历， 假设有一颗 这样的二叉树，使用前中后序方式遍历
 *           5
 *        /     \
 *      4        6
 *   /   \     /   \
 * 1      2   7     8
 */
public class BinaryTreeSelect {
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
//        System.out.println(preorder(binaryTree.getRoot()));
//        System.out.println(inorder(binaryTree.getRoot()));
        System.out.println(postorder(binaryTree.getRoot()));
    }

    //前序遍历，中 - 左 - 右
    public static List<Integer> preorder(BinaryTree.TreeNode root) {
        if (root == null) {
            return arrayList;
        }
        arrayList.add(root.val);
        preorder(root.leftNode);
        preorder(root.rightNode);
        return arrayList;
    }

    //中序遍历， 左 - 中 - 右
    public static List<Integer> inorder(BinaryTree.TreeNode root) {
        if (root == null) {
            return arrayList;
        }
        inorder(root.leftNode);
        arrayList.add(root.val);
        inorder(root.rightNode);
        return arrayList;
    }
    //后序遍历，右 - 左 - 中
    public static List<Integer> postorder(BinaryTree.TreeNode root){
        if (root == null){
            return arrayList;
        }
        postorder(root.rightNode);
        postorder(root.leftNode);
        arrayList.add(root.val);
        return arrayList;
    }
}

//二叉树结构
class BinaryTree {
    private final TreeNode root;
    static class TreeNode {
        int val;
        TreeNode leftNode;
        TreeNode rightNode;

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
}
