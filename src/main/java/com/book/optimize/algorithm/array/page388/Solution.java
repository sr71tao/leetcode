package com.book.optimize.algorithm.array.page388;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by yuntao.wu on 2019/11/12.
 * 给定整形数组，求出排序后相邻两数的最大差值，时间复杂度O(N)
 */
public class Solution {


    public int getMaxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int maxResult = 0;
        int maxV = Integer.MIN_VALUE;
        int minV = Integer.MAX_VALUE;
        for (int n : nums) {
            maxV = Math.max(maxV, n);
            minV = Math.min(minV, n);
        }
        if (maxV == minV) {
            return 0;
        }

        int[] maxArr = new int[nums.length + 1];
        int[] minArr = new int[nums.length + 1];
        IntStream.range(0,nums.length).forEach(i-> {maxArr[i]=Integer.MIN_VALUE; minArr[i] = Integer.MAX_VALUE;});
        minArr[nums.length] = maxV;
        for (int n : nums) {
            int idx = (n-minV) * nums.length / (maxV - minV);
            maxArr[idx] = Math.max(maxArr[idx], n);
            minArr[idx] = Math.min(minArr[idx], n);
        }
        for (int j = -1,i = 0; i <= nums.length; i++) {
            if (minArr[i] == Integer.MAX_VALUE) {
                continue;
            }
            if (j != -1) {
                maxResult = Math.max(maxResult, minArr[i] - maxArr[j]);
            }
            j = i;
        }
        return maxResult;
    }

    public int getMaxGapExample(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int maxResult = 0;
        int maxV = Integer.MIN_VALUE;
        int minV = Integer.MAX_VALUE;
        for (int n : nums) {
            maxV = Math.max(maxV, n);
            minV = Math.min(minV, n);
        }
        if (maxV == minV) {
            return 0;
        }

        boolean[] hasNum = new boolean[nums.length + 1];
        int[] maxArr = new int[nums.length + 1];
        int[] minArr = new int[nums.length + 1];
        minArr[nums.length] = maxV;
        hasNum[nums.length] = true;
        for (int n : nums) {
            int idx = (n-minV) * nums.length / (maxV - minV);
            maxArr[idx] = hasNum[idx]? Math.max(maxArr[idx], n) : n;
            minArr[idx] = hasNum[idx]? Math.min(minArr[idx], n) : n;
            hasNum[idx] = true;
        }
        for (int j = -1,i = 0; i <= nums.length; i++) {
            if (!hasNum[i]) {
                continue;
            }
            if (j != -1) {
                maxResult = Math.max(maxResult, minArr[i] - maxArr[j]);
            }
            j = i;
        }
        return maxResult;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.getMaxGapExample(new int[]{-1,5,5,9,5,8}));
//        System.out.println(solution.getMaxGap(new int[]{-1,5,5,3,5,8}));

    }

    private void print(int[] nums){
        Arrays.stream(nums).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

}
