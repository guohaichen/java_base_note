package com.Algorithmic_thinking.tree.query;

import com.Algorithmic_thinking.tree.BinaryTree;
import com.Algorithmic_thinking.tree.BinaryTree.TreeNode;

import java.util.*;

/**
 * @author cgh
 * @create 2023-07-17
 * 二叉树的遍历，非递归法
 * 核心思路 还是将最后遍历的结果 保存到了一个数组中，栈只是临时存放节点；
 */
public class BinaryTreeQueryByStack {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.getRoot();
        if (root == null) {
            return;
        }
        System.out.println("前序遍历: " + preorder(binaryTree.getRoot()));
        System.out.println("中序遍历: " + inOrder(binaryTree.getRoot()));
        System.out.println("后序遍历: " + postorder(binaryTree.getRoot()));
    }

    //栈的方式前序遍历二叉树
    public static List<Integer> preorder(BinaryTree.TreeNode root) {
        //用来存放最后结果
        List<Integer> resultList = new ArrayList<>();
        //栈用来临时存放节点，
        Stack<BinaryTree.TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTree.TreeNode node = stack.pop();
            resultList.add(node.val);
            //前序遍历 根 - 左 - 右 ，根据栈的特点，先进后出，所以要先存放右节点。
            if (node.rightNode != null) {
                stack.push(node.rightNode);
            }
            if (node.leftNode != null) {
                stack.push(node.leftNode);
            }
        }
        return resultList;
    }

    // 中序遍历 左-跟-右 另一种写发。稍微改改就是前序遍历
    public static List<Integer> inOrder(BinaryTree.TreeNode root) {
        List<Integer> list = new ArrayList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                //左子树
                stack.push(current);
                //前序遍历
//                list.add(current.val);
                current = current.leftNode;
            } else {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                current = pop.rightNode;
            }
        }
        return list;
    }

    //后序遍历,后续遍历的思路：
    public static List<Integer> postorder(BinaryTree.TreeNode root) {

        ArrayList<Integer> resultList = new ArrayList<>();

        Stack<BinaryTree.TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            BinaryTree.TreeNode node = stack.pop();
            resultList.add(node.val);
            if (node.leftNode != null) {
                stack.push(node.leftNode);
            }
            if (node.rightNode != null) {
                stack.push(node.rightNode);
            }
        }
        Collections.reverse(resultList);
        return resultList;
    }
}
