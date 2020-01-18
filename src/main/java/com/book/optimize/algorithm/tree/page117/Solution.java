package com.book.optimize.algorithm.tree.page117;

import com.book.optimize.algorithm.tree.Node;

/**
 * Created by yuntao.wu on 2019/9/25.
 * 找最大搜索二叉树
 */
public class Solution {


    public Result getBiggestBST(Node root) {
        if (root == null) {
            return null;
        }
        Result result = new Result();
        result.head = root;
        result.min = root.val;
        result.max = root.val;
        Result leftBST = getBiggestBST(root.left);
        Result rightBST = getBiggestBST(root.right);
        boolean flag = true;
        if (leftBST != null) {
            flag &= leftBST.bst;
            if (leftBST.max > root.val) {
                flag = false;
            } else {
                result.num += leftBST.num;
            }
            result.min = Math.min(result.min, leftBST.min);
            result.max = Math.max(result.max, leftBST.max);
        }
        if (rightBST != null) {
            flag &= rightBST.bst;
            if (rightBST.min < root.val) {
                flag = false;
            } else {
                result.num += rightBST.num;
            }
            result.min = Math.min(result.min, rightBST.min);
            result.max = Math.max(result.max, rightBST.max);
        }
        result.bst = flag;
        // 非平衡二叉树
        if (flag) {
            return result;
        }
        if (leftBST != null && rightBST != null) {
            if (leftBST.num < rightBST.num) {
                result.num = rightBST.num;
                result.head = rightBST.head;
            } else {
                result.num = leftBST.num;
                result.head = leftBST.head;
            }
        } else if (leftBST != null) {
            result.num = leftBST.num;
            result.head = leftBST.head;
        } else if (rightBST != null) {
            result.num = rightBST.num;
            result.head = rightBST.head;
        }
        return result;
    }

    // 0:num, 1:min ,2:max
    public Node getBiggestBSTExample(Node root, int[] num) {
        if (root == null) {
            num[0] = 0;
            num[1] = Integer.MAX_VALUE;
            num[2] = Integer.MIN_VALUE;
            return null;
        }
        Node left = getBiggestBSTExample(root.left, num);
        int lNum = num[0];
        int lMin = num[1];
        int lMax = num[2];
        Node right = getBiggestBSTExample(root.right, num);
        int rNum = num[0];
        int rMin = num[1];
        int rMax = num[2];
        num[1] = Math.min(lMin, root.val);
        num[2] = Math.max(root.val, rMax);
        if (left == root.left && right == root.right && lMax <= root.val && root.val <= rMin) {
            num[0] += lNum + rNum + 1;
            return root;
        }
        num[0] = Math.max(rNum,lNum);
        return rNum > lNum? right : left;
    }

    public static void main(String[] args) {
        Node root = Node.buildTree(new Integer[]{6,1,12,0,3,10,13,null,null,null,null,4,14,20,16,null,null,null,null,null,null,null,null,2,5,11,15});
//        Node root = Node.buildTree(new Integer[]{6,1,17,0,3,15,18,null,null,null,null,9,19,29,25,null,null,null,null,null,null,null,null,7,10,16,21});

        Node.preOrder(root);
        Node.midOrder(root);

        Solution solution = new Solution();
        Node node = solution.getBiggestBSTExample(root, new int[3]);
        System.out.println(node.val);
        Node.preOrder(node);

    }

    protected static class Result {
        Node head;
        int num = 1;
        int max;
        int min;
        boolean bst = true;
    }
}
