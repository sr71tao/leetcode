package com.book.optimize.algorithm.tree.page147;

import com.book.optimize.algorithm.tree.Node;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuntao.wu on 2019/10/2.
 * 分别判断是否是搜索二叉树&完全二叉树
 */
public class Solution {

    public boolean isBST(Node node) {
        if (node == null) {
            return false;
        }
        return checkBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (min > node.val || node.val > max) {
            return false;
        }
        return checkBST(node.left, min, node.val) && checkBST(node.right, node.val, max);
    }

    public boolean isCBT(Node root) {
        if (root == null) {
            return false;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.right != null && node.left == null) {
                return false;
            }
            if (leaf && (node.left != null || node.right != null)) {
                return false;
            }
            if (node.right == null) {
                leaf = true;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Node node = Node.buildTree("8!4!2!#!#!7!#!#!12!10!#!#!14!#!#!");
//        Node.preOrder(node);
//        Node.midOrder(node);
//        System.out.println(solution.isBST(node));

        System.out.println(solution.isCBT(node));
    }
}
