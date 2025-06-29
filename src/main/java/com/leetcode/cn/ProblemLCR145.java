package com.leetcode.cn;

import com.model.TreeNode;

/**
 * Created by wuyuntao on 2025/4/26
 * 判断一棵二叉树是否 轴对称
 *0 <= 节点个数 <= 1000
 */
public class ProblemLCR145 {

    public static void main(String[] args) {

        ProblemLCR145 problem = new ProblemLCR145();
        System.out.println(problem.checkSymmetricTree(TreeNode.buildTree(new Integer[]{6,7,7,8,9,9,8})));
        System.out.println(problem.checkSymmetricTree(TreeNode.buildTree(new Integer[]{6,7,7,8,null,8,null})));
//        System.out.println(problem.checkSymmetricTree(TreeNode.buildTree(new Integer[]{6,7,7,8,9,9,8})));
//        System.out.println(problem.checkSymmetricTree(TreeNode.buildTree(new Integer[]{6,7,7,8,9,9,8})));
    }


    public boolean checkSymmetricTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkTwoSubTree(root.left, root.right);
    }


    public boolean checkTwoSubTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return checkTwoSubTree(left.left, right.right) && checkTwoSubTree(left.right, right.left);
    }


}
