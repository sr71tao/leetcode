package com.book.optimize.algorithm.tree.page144;

import com.book.optimize.algorithm.tree.Node;

/**
 * Created by yuntao.wu on 2019/10/1.
 * 判断是否为平衡二叉树
 */
public class Solution {

    public boolean isBBT(Node node) {
        Info info = getHigh(node);
        System.out.println(info.high);
        return info.balance;
    }
    private Info getHigh(Node node) {
        if (node == null) {
            return new Info(0, true);
        }
        Info leftInfo = getHigh(node.left);
        Info rightInfo = getHigh(node.right);
        if (leftInfo.balance && rightInfo.balance) {
            if (Math.abs(leftInfo.high-rightInfo.high) < 2) {
                return new Info(Math.max(leftInfo.high, rightInfo.high) + 1, true);
            }
        }
        return new Info(Math.max(leftInfo.high, rightInfo.high) + 1, false);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node = Node.buildTree(new Integer[]{0,1,3,2,null,null,null});
        System.out.println(solution.isBBT(node));

        node = Node.buildTree("0!1!2!#!#!#!#!");
        System.out.println(solution.isBBT(node));
    }

    static class Info {
        int high;
        boolean balance;

        Info(int h, boolean flag) {
            high = h;
            balance = flag;
        }
    }
}
