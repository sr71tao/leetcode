package com.leetcode.problems.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuntao.wu on 2019/10/22.
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric
 */
public class Problem101 {



    public boolean isSymmetricExample(TreeNode root) {
        return root == null || isMirror(root, root);
    }

    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            if (!check(stack)) {
                return false;
            }
            int size = stack.size();
            int i = 0;
            while(i++ < size) {
                TreeNode node = stack.pop();
                if (node == null ) {
                    continue;
                }
                stack.add(node.left);
                stack.add(node.right);
            }
        }
        return true;
    }


    private boolean check(List<TreeNode> stack){
        for (int i =0, j = stack.size()-1; i< stack.size() && j >=0 ; i++, j--) {
            if (stack.get(i) != null && stack.get(j) != null) {
                if (stack.get(i).val != stack.get(j).val) {
                    return false;
                }
            } else if (stack.get(i) == null && stack.get(j) == null) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }




    public static void main(String[] args) {
        System.out.println(null == null);
    }



    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

}
