package com.interview;

import java.util.Arrays;

/**
 * Created by yuntao.wu on 2020/3/19.
 * 给定一个三角形，找出从上到下的最小路径和，每一步只能移动到下一行的相邻的节点
 * [
 * [1]
 * [5,4]
 * [6,2,7]
 * [4,1,8,3]
 * ]
 */
public class ToutiaoInterview1 {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1},
                {5,4},
                {6,2,7},
                {4,1,8,3}
        };
        System.out.println(getMinValue(nums));
    }

    private static int getMinValue(int[][] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] result = new int[nums[nums.length-1].length];
        for (int i = 0; i < nums.length; i++) {
            int tmp = result[0];
            result[0] += nums[i][0];
            for (int j = 1; j < i; j++) {
                int curVal = Math.min(result[j-1], result[j]) + nums[i][j];
                tmp = result[j];
                result[j] = curVal;
            }
            result[i] = tmp + nums[i][i];
        }
        return Arrays.stream(result).min().orElse(0);
    }


}
