package com.book.offer.interview27;

import com.book.offer.common.Node;

/**
 * Created by yuntao.wu on 2020/1/13.
 * 平衡二叉树转双向链表
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node = Node.buildTree("5!2!1!#!#!3!#!#!8!#!9!#!#!");
        Node.preOrder(node);
//        Node.midOrder(node);

        Node[] arr = new Node[1];
        solution.transfer2Linked(node, arr);
        Node lastOne = arr[0];
        if (lastOne == null) {
            return ;
        }
        while(lastOne.left != null) {
            System.out.print(lastOne.val + " ");
            lastOne = lastOne.left;
        }
        System.out.println(lastOne.val);
        while(lastOne.right != null) {
            System.out.print(lastOne.val + " ");
            lastOne = lastOne.right;
        }
        System.out.println(lastOne.val);
    }

    /**
     *
     * @param node  当前遍历节点
     * @param last  按顺序最后节点
     */
    private void transfer2Linked(Node node, Node[] last) {
        if (node == null) {
            return;
        }
        transfer2Linked(node.left, last);

        node.left = last[0];
        if (last[0] != null) {
            last[0].right = node;
        }
        last[0] = node;

        transfer2Linked(node.right, last);

    }

}
