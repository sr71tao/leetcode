package com.book.optimize.algorithm.tree.page178;

import com.book.optimize.algorithm.tree.Node;

/**
 * Created by yuntao.wu on 2019/10/14.
 * 完全二叉树求节点数量，时间复杂度小于O(n)
 */
public class Solution {



    public int getCount(Node node, int lev, int high) {
        if (node == null) {
            return 0;
        }

        int rhigh = getHigh(node.right, lev+1);
        if (rhigh == high) {
            return (int) (Math.pow(2,high-lev) + getCount(node.right, lev+1,high));
        }
        return (int) (getCount(node.left, lev+1, high) + Math.pow(2,high-1-lev));
    }


    private int getHigh(Node node, int lev) {
        while(node != null) {
            node = node.left;
            lev += 1;
        }
        return lev-1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node = Node.buildTree(new Integer[]{1,2,3,4,5,6,7,8,9,10,11});
//        Node.preOrder(node);
//        Node.midOrder(node);
        System.out.println(solution.getHigh(node,1));
        System.out.println(solution.getCount(node,1,solution.getHigh(node,1)));
    }
}
