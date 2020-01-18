package com.leetcode.contest.contest48;

import org.junit.Test;

/**
 * Created by yuntao.wu on 2017/9/3.
 */
public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void findSecondMinimumValue(){
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;


        System.out.println(solution.findSecondMinimumValue(root));
    }

    @Test
    public void maximumSwap(){
        System.out.println(solution.maximumSwap(98368));
    }
}
