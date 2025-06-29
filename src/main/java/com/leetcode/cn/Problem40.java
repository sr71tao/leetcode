package com.leetcode.cn;

import java.lang.invoke.StringConcatFactory;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by wuyuntao on 2025/3/29
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class Problem40 {

    private List<int[]> freq = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> sequence = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        for (int num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size-1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                ++freq.get(size-1)[1];
            }
        }
        recursiveSum(0, target);
        return result;
    }

    private void recursiveSum(int post, int rest) {
        if (rest == 0) {
            result.add(new ArrayList<>(sequence));
            return;
        }
        if (post >= freq.size() || rest < freq.get(post)[0]) {
            return;
        }

        recursiveSum(post+1, rest);
        int minCount = Math.min(freq.get(post)[1], rest/freq.get(post)[0]);
        for (int i = 1; i <= minCount; i++) {
            sequence.add(freq.get(post)[0]);
            recursiveSum(post+1, rest - i * freq.get(post)[0]);
        }

        for (int i = 1; i <= minCount; i++) {
            sequence.remove(sequence.size()-1);
        }

    }


    public static void main(String[] args) {
        Problem40 problem = new Problem40();
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> result = problem.combinationSum2(candidates, 8);
        for (List<Integer> list : result) {
            for (Integer elem : list) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }


}
