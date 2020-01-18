package com.book.optimize.algorithm.tree.page151;

import com.book.optimize.algorithm.tree.PNode;

/**
 * Created by yuntao.wu on 2019/10/6.
 * 二叉树找后续节点
 */
public class Solution {


    public PNode getNext(PNode node) {
        if (node == null) {
            return null;
        }
        // 存在右节点
        if (node.right != null) {
            PNode lNode = node.right;
            while(lNode.left != null) {
                lNode = lNode.left;
            }
            return lNode;
        }
        // 父节点 且为右
        PNode prev = node;
        PNode next = node.parent;
        while(next != null && next.right == prev) {
            prev = next;
            next = next.parent;
        }
        return next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        PNode node = PNode.buildTree("6!3!1!#!2!#!#!4!#!5!#!#!9!8!7!#!#!#!10!#!#!");
        PNode node = PNode.buildTree(new Integer[]{6,3,9,1,4,8,10,null,2,null,5,7});
        PNode.preOrder(node);
        PNode.midOrder(node);

        PNode next = solution.getNext(node.right.left);
        System.out.println(next == null? "null" : next.val);

    }
}
