package com.leetcode.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import com.model.TreeNode;

/**
 * Created by wuyuntao on 2025/4/27
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100
 */
public class Problem199 {

    public static void main(String[] args) {
        Problem199 problem = new Problem199();
        TreeNode root = TreeNode.buildTree(new Integer[]{3, 1,2, null, 3, null,6, 8, 7});
        problem.rightSideView(root).forEach(System.out::print);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        recursive(root, 1, result);
        return result;
    }

    private void recursive(TreeNode root, int depth, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (result.size() < depth) {
            result.add(root.val);
        }
        recursive(root.right, depth+1, result);
        recursive(root.left, depth+1, result);
    }
}
