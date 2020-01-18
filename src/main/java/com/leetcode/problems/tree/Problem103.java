package com.leetcode.problems.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuntao.wu on 2019/10/24.
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 */
public class Problem103 {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> stack = new LinkedList();
        stack.add(root);
        int lev = 1;
        while (!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> levelList = new LinkedList<>();
            while (size-- > 0) {
                if ((lev & 1) == 1) {
                    TreeNode node = stack.removeFirst();
                    levelList.add(node.val);
                    if (node.left != null) {
                        stack.add(node.left);
                    }
                    if (node.right != null) {
                        stack.add(node.right);
                    }
                } else {
                    TreeNode node = stack.removeLast();
                    levelList.add(node.val);
                    if (node.right != null) {
                        stack.addFirst(node.right);
                    }
                    if (node.left != null) {
                        stack.addFirst(node.left);
                    }

                }

            }

            if (!levelList.isEmpty()) {
                result.add(levelList);
            }
            lev++;
        }

        return result;
    }


    public static void main(String[] args) {
        Problem103 problem = new Problem103();

    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
