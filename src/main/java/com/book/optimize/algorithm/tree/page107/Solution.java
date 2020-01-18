package com.book.optimize.algorithm.tree.page107;

import com.book.optimize.algorithm.tree.Node;

/**
 * Created by yuntao.wu on 2019/9/16.
 * 遍历二叉树最优算法
 */
public class Solution {

    private void midMorris(Node root) {
        if (root == null) {
            return ;
        }
        Node cur1 = root;
        while(cur1 != null) {
            Node cur2 = cur1.left;
            if (cur2 == null) {
                System.out.print(cur1.val + " ");
                cur1 = cur1.right;
                continue;
            }
            while(cur2.right != null && cur2.right != cur1) {
                cur2 = cur2.right;
            }
            if (cur2.right == null) {
                cur2.right = cur1;
                cur1 = cur1.left;
            } else {
                cur2.right = null;
                System.out.print(cur1.val +  " ");
                cur1 = cur1.right;
            }
        }
        System.out.println();
    }

    private void preMorris(Node root) {
        if (root == null) {
            return ;
        }
        Node cur1 = root;
        while(cur1 != null) {
            Node cur2 = cur1.left;
            if (cur2 == null) {
                System.out.print(cur1.val + " ");
                cur1 = cur1.right;
                continue;
            }
            while(cur2.right != null && cur2.right != cur1) {
                cur2 = cur2.right;
            }
            if (cur2.right == null) {
                cur2.right = cur1;
                System.out.print(cur1.val +  " ");
                cur1 = cur1.left;
            } else {
                cur2.right = null;
                cur1 = cur1.right;
            }
        }
        System.out.println();
    }


    public void postMorris(Node root) {
        if (root == null) {
            return;
        }
        Node cur1 = root;
        while(cur1 != null) {
            Node cur2 = cur1.left;
            if (cur2 == null) {
                cur1 = cur1.right;
                continue;
            }
            while(cur2.right != null && cur2.right != cur1) {
                cur2 = cur2.right;
            }
            if (cur2.right == null) {
                cur2.right = cur1;
                cur1 = cur1.left;
            } else {
                cur2.right = null;
                printLeftEdge(cur1.left);
                cur1 = cur1.right;
            }
        }
        printLeftEdge(root);
        System.out.println();
    }



    private void printLeftEdge(Node root) {
        if (root == null) {
            return;
        }
        Node tail = reverseNode(root);
        Node cur = tail;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        reverseNode(tail);
    }

    private Node reverseNode(Node from) {
        if (from == null) {
            return null;
        }
        Node prev = null;
        Node cur = from;
        while(cur != null) {
            Node next = cur.right;
            cur.right = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node root = Node.buildTree(new Integer[]{4,2,6,1,3,5,7});
        //Node.midOrder(root);

        solution.midMorris(root);
        solution.preMorris(root);
        solution.postMorris(root);

       /* Stream.iterate(0, item->item+1).limit(page115).forEach(System.out::print);
        System.out.println();

        Node node1 = Node.buildSingleLink(new Integer[]{1,2,3,4,page115});

        Node.printSingleLink(node1);
        node1 = solution.reverseNode(node1);
        Node.printSingleLink(node1);*/
    }



}
