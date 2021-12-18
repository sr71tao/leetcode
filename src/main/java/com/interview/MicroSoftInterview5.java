package com.interview;

/**
 * 二叉树，有父节点，找出下一个中序遍历节点
 * Created by wuyuntao on 2021/12/17
 */
public class MicroSoftInterview5 {

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6, 7, null, 8, 9, null, null, null, 10};
        TreeNode[] nodes = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == null) {
                continue;
            }
            nodes[i] = new TreeNode(nums[i]);
        }
        buildTree(nodes);
        TreeNode next = getMidOrderNextNode(nodes[6]);
        System.out.println(next != null ? next.val : null);
    }

    private static void buildTree(TreeNode[] nodes) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == null) {
                continue;
            }
            int leftIdx = 2 * i + 1;
            int rightIdx = leftIdx + 1;
            if (leftIdx < nodes.length && nodes[leftIdx] != null) {
                nodes[i].left = nodes[leftIdx];
                nodes[leftIdx].parent = nodes[i];
            }
            if (rightIdx < nodes.length && nodes[rightIdx] != null) {
                nodes[i].right = nodes[rightIdx];
                nodes[rightIdx].parent = nodes[i];
            }
        }
    }

    private static TreeNode getMidOrderNextNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            TreeNode subNode = node.right;
            while (subNode.left != null) {
                subNode = subNode.left;
            }
            return subNode;
        }
        TreeNode cur = node;
        TreeNode parent = node.parent;
        while (parent != null && parent.right == cur) {
            cur = parent;
            parent = parent.parent;
        }
        return parent;
    }

    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
