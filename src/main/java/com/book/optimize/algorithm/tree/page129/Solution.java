package com.book.optimize.algorithm.tree.page129;

import com.book.optimize.algorithm.tree.Node;

import java.util.LinkedList;

/**
 * Created by yuntao.wu on 2019/10/11.
 * zigZag打印二叉树
 */
public class Solution {


    public void zigZag(int h, LinkedList<Node> queue) {
        if (queue.isEmpty()) {
            return ;
        }
        boolean rSide = (h&1) == 0;
        int size = queue.size();
        while(size-- > 0) {
            if (rSide) {
                Node node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                Node node = queue.pollLast();
                System.out.print(node.val + " ");
                if (node.right != null) {
                    queue.push(node.right);
                }
                if (node.left != null) {
                    queue.push(node.left);
                }
            }
        }
        System.out.println();
        zigZag(h+1, queue);
    }


    public void zigZagExample(Node node) {
        if (node == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        int level = 1;
        boolean rt = (level&1) != 0;
        Node nLast = null;
        Node last = node;
        queue.offer(node);
        Node head = null;
        while(!queue.isEmpty()) {
            if (rt) {
                head = queue.pollFirst();
                if (head.left != null) {
                    nLast = nLast == null? head.left : nLast;
                    queue.offerLast(head.left);
                }
                if (head.right != null) {
                    nLast = nLast == null? head.right : nLast;
                    queue.offerLast(head.right);
                }
            } else {
                head = queue.pollLast();
                if (head.right != null) {
                    nLast = nLast == null? head.right : nLast;
                    queue.offerFirst(head.right);
                }
                if (head.left != null) {
                    nLast = nLast == null? head.left : nLast;
                    queue.offerFirst(head.left);
                }
            }
            System.out.print(head.val + " ");
            if (head == last && !queue.isEmpty()) {
                System.out.println();
                last = nLast;
                nLast = null;
                ++level;
                rt = !rt;
            }
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        Node node = Node.buildTree("1!2!4!#!#!5!8!#!#!#!3!#!7!#!#!");
        Node node = Node.buildTree("1!2!4!#!#!#!3!5!7!#!#!8!#!#!6!#!#!");

//        Node.preOrder(node);
//        Node.midOrder(node);

        /*LinkedList<Node> list = new LinkedList<>();
        list.add(node);
        solution.zigZag(0, list);*/
        solution.zigZagExample(node);
    }
}
