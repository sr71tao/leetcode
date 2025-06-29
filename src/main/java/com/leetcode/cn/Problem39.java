package com.leetcode.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wuyuntao on 2025/3/29
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 */
public class Problem39 {

    public static void main(String[] args) {
        Problem39 problem = new Problem39();
        int[] candidates = new int[]{2,3,5};
        List<List<Integer>> result = problem.combinationSum(candidates, 8);
        for (List<Integer> list : result) {
            for (Integer elem : list) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> finalResult = new LinkedList<>();
        recursiveSum(candidates, target, 0, 0, new LinkedList<>(), finalResult);
        return finalResult;
    }

    private void recursiveSum(int[] candidates, int target, int idx, int sum, List<Integer> singleResult, List<List<Integer>> finalResult) {
        for (int i = idx; i < candidates.length; i++) {
            int newSum = candidates[i] + sum;
            if (newSum == target) {
                List<Integer> list = new ArrayList<>(singleResult);
                list.add(candidates[i]);
                finalResult.add(list);
            } else if (newSum < target) {
                singleResult.add(candidates[i]);
                recursiveSum(candidates, target, i, sum+candidates[i], singleResult, finalResult);
                singleResult.remove(Integer.valueOf(candidates[i]));
            }
        }
    }
}
