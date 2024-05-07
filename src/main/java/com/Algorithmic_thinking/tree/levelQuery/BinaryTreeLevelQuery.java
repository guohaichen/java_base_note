package com.Algorithmic_thinking.tree.levelQuery;

import com.Algorithmic_thinking.tree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cgh
 * @create 2023-07-14
 * 二叉树的 层序遍历 （更正为广度优先搜索）注意， 深度优先dfs指的是前中后序遍历；
 * leetcode 102
 */
public class BinaryTreeLevelQuery {
    public static void main(String[] args) {
        //使用之前构造的二叉树
        BinaryTree binaryTree = new BinaryTree();
        System.out.println(levelQuery(binaryTree.getRoot()));
    }


    public static List<List<Integer>> levelQuery(BinaryTree.TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        //存放每层node
        List<List<Integer>> levelList = new ArrayList<>();
        //借助队列，先进先出
        Queue<BinaryTree.TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //存放node
            ArrayList<Integer> nodeList = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                BinaryTree.TreeNode tmpNode = queue.poll();
                nodeList.add(tmpNode.val);
                if (tmpNode.leftNode != null) {
                    queue.offer(tmpNode.leftNode);
                }
                if (tmpNode.rightNode != null) {
                    queue.offer(tmpNode.rightNode);
                }
                size--;
            }
            levelList.add(nodeList);
        }
        return levelList;
    }
}
