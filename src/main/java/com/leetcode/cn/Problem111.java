package com.leetcode.cn;


import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wuyuntao on 2024/5/14
 */
public class Problem111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }


    public static void main(String[] args) {
        Problem111 problem111 = new Problem111();
        TreeNode root = TreeNode.build(new Integer[]{2,null,3,null,4,null,5,null,6});
        System.out.println(problem111.minDepth(root));
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public static TreeNode build(Integer[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        if (nums[0] == null) {
            return null;
        }
        List<TreeNode> nodes = Arrays.stream(nums).map(e -> {
            if (e == null) {
                return null;
            }
            return new TreeNode(e);
        }).collect(Collectors.toList());
        buildLayer(nodes,0 , new LinkedList<>());
        return nodes.get(0);
    }

    private static void buildLayer(List<TreeNode> nodes, int curIdx, List<Integer> parents) {
        if (curIdx == 0) {
            buildLayer(nodes, 1, Lists.newArrayList(0));
            return;
        }
        if (curIdx >= nodes.size() || parents.size() == 0) {
            return;
        }
        List<Integer> nextParents = Lists.newArrayList();
        int idx = curIdx, pIdx = 0;
        for (; idx < nodes.size() && pIdx < parents.size(); idx+=2, pIdx++) {
            TreeNode left = nodes.get(idx);
            if (left != null) {
                nextParents.add(idx);
            }
            nodes.get(parents.get(pIdx)).left = left;
            if (idx+1 == nodes.size()) {
                return;
            }
            TreeNode right = nodes.get(idx+1);
            if (right != null) {
                nextParents.add(idx+1);
            }
            nodes.get(parents.get(pIdx)).right = right;
        }
        buildLayer(nodes, idx, nextParents);
    }
}