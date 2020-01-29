package com.book.offer.interview23;

import com.book.offer.common.Node;

import java.util.LinkedList;

/**
 * Created by Acer on 2020/1/29.
 * 按层打印二叉树
 */
public class Solution {


    private void printLevel(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node node = list.removeFirst();
            System.out.print(node.val + " ");
            if (node.left != null) {
                list.addLast(node.left);
            }
            if (node.right != null) {
                list.addLast(node.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node = Node.buildTree(new Integer[]{8,6,10,5,null,9,11});
        Solution solution = new Solution();
        solution.printLevel(node);
    }
}
