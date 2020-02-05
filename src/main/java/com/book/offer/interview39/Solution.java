package com.book.offer.interview39;

import com.book.offer.common.Node;

/**
 * Created by Acer on 2020/2/4.
 * 二叉树深度
 */
public class Solution {

    private int getMaxHigh(Node root) {
        if (root == null) {
            return 0;
        }
        int max = Math.max(getMaxHigh(root.left), getMaxHigh(root.right));
        return max+1;
    }

    private int isBT(Node root, boolean[] result) {
        if (root == null) {
            return 0;
        }
        int leftHigh = isBT(root.left, result);
        int rightHigh = isBT(root.right, result);
        if (Math.abs(leftHigh-rightHigh) > 1) {
            result[0] = false;
        }
        return Math.min(leftHigh, rightHigh) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node = Node.buildTree(new Integer[]{1,2,3,4,5,null,6,null,null,7});
        System.out.println(solution.getMaxHigh(node));
        boolean[] result = new boolean[1];
        result[0] = true;
        System.out.println(solution.isBT(node,result));
        System.out.println(result[0]);
    }
}
