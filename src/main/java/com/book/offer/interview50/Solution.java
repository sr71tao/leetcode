package com.book.offer.interview50;

import com.book.offer.common.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuntao.wu on 2020/3/15.
 * 两个节点最低公共祖先
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
//        Node root = Node.buildTree("1!2!3!4!5!#!#!6!7!8!9!#!#!#!#!#!#!#!#!");
        Node root = Node.buildTree("1!2!4!6!#!#!7!#!#!5!8!#!#!9!#!#!3!#!#!");

        Node node1 = root.left.left.left;
        Node node2 = root.left.right.left;
        Node node = solution.getParent(root, node1, node2);
        System.out.println(node == null? "null" : node.val);
    }

    private Node getParent(Node root, Node node1, Node node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        LinkedList<Node> path1 = new LinkedList<>();
        LinkedList<Node> path2 = new LinkedList<>();
        boolean flag1 = preOrder(root, node1, path1);
        if (!flag1) {
            return null;
        }
        boolean flag2 = preOrder(root, node2, path2);
        if (!flag2) {
            return null;
        }
        int len = Math.min(path1.size(), path2.size());
        Node resultNode = null;
        int i = 0;
        while (i < len) {
            Node cur1 = path1.get(i);
            Node cur2 = path2.get(i++);
            if (cur1 != cur2) {
                return resultNode;
            }
            resultNode = cur1;
        }
        return resultNode;
    }

    private boolean preOrder(Node node, Node target, LinkedList<Node> list) {
        if (node == null) {
            return false;
        }
        list.add(node);
        if (node == target) {
            return true;
        }
        if (preOrder(node.left, target, list) || preOrder(node.right, target, list)) {
            return true;
        }
        list.pollLast();
        return false;
    }

}
