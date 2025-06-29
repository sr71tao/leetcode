package com.leetcode.cn;

import java.util.LinkedList;
import java.util.List;

import com.model.TreeNode;

/**
 * Created by wuyuntao on 2025/5/1
 *
 * 一棵圣诞树记作根节点为 root 的二叉树，节点值为该位置装饰彩灯的颜色编号。请按照如下规则记录彩灯装饰结果：
 * 第一层按照从左到右的顺序记录
 * 除第一层外每一层的记录顺序均与上一层相反。即第一层为从左到右，第二层为从右到左
 *
 *输入：root = [8,17,21,18,null,null,6]
 * 输出：[[8],[21,17],[18,6]]
 *
 */
public class ProblemLCR151 {

    public static void main(String[] args) {
        ProblemLCR151 problem = new ProblemLCR151();
        List<List<Integer>> result = problem.decorateRecord(TreeNode.buildTree(new Integer[]{8,17,21,18,null,null,6}));

        for (List<Integer> list : result) {
            list.forEach(e -> System.out.print(e +" "));
            System.out.println();
        }
    }

    public List<List<Integer>> decorateRecord(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> curLevelNodes = new LinkedList<>();
        curLevelNodes.add(root);
        int level = 1;
        while (!curLevelNodes.isEmpty()) {
            List<TreeNode> nextLevelNodes = new LinkedList<>();
            LinkedList<Integer> curLevelVal = new LinkedList<>();
            int size = curLevelNodes.size();
            for (int i = size-1; i >= 0; i--) {
                TreeNode node = curLevelNodes.get(i);
                curLevelVal.push(node.val);
                if (level % 2 == 0) {
                    if (node.left != null) {
                        nextLevelNodes.add(node.left);
                    }
                    if (node.right != null) {
                        nextLevelNodes.add(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextLevelNodes.add(node.right);
                    }
                    if (node.left != null) {
                        nextLevelNodes.add(node.left);
                    }
                }
            }
            ++level;
            curLevelNodes = nextLevelNodes;
            result.add(curLevelVal);
        }

        return result;
    }
}
