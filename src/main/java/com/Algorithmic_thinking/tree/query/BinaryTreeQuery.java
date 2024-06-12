package com.Algorithmic_thinking.tree.query;

import com.Algorithmic_thinking.tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cgh
 * @create 2023-07-14
 * 二叉树的前中后序遍历， 假设有一颗 这样的二叉树，使用前中后序方式遍历
 * 递归法
 *           5
 *        /     \
 *      4        6
 *   /   \     /   \
 * 1      2   7     8
 */
public class BinaryTreeQuery {
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
//        System.out.println(preorder(binaryTree.getRoot()));
        System.out.println(inorder(binaryTree.getRoot()));
//        System.out.println(postorder(binaryTree.getRoot()));
    }

    //前序遍历，根 - 左 - 右
    public static List<Integer> preorder(BinaryTree.TreeNode root) {
        if (root == null) {
            return arrayList;
        }
        arrayList.add(root.val);
        preorder(root.leftNode);
        preorder(root.rightNode);
        return arrayList;
    }

    //中序遍历， 左 - 根 - 右
    public static List<Integer> inorder(BinaryTree.TreeNode root) {
        if (root == null) {
            return arrayList;
        }
        inorder(root.leftNode);
        arrayList.add(root.val);
        inorder(root.rightNode);
        return arrayList;
    }

    //后序遍历，左 - 右 - 根
    public static List<Integer> postorder(BinaryTree.TreeNode root){
        if (root == null){
            return arrayList;
        }
        postorder(root.leftNode);
        postorder(root.rightNode);
        arrayList.add(root.val);
        return arrayList;
    }
}

