package com.book.offer.version2.interview47;

/**
 * 礼物最大价值
 * Created by yuntao.wu on 2021/12/13.
 */
public class Solution {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };

        System.out.println(getMaxValue(nums));
    }

    private static int getMaxValue(int[][] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] help = new int[nums[0].length];
        for (int j = 0; j < help.length; j++) {
            help[j] = (j > 0 ? help[j - 1] : 0) + nums[0][j];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (j == 0) {
                    help[j] += nums[i][j];
                } else {
                    help[j] = Math.max(help[j - 1], help[j]) + nums[i][j];
                }
            }
        }
        return help[help.length - 1];
    }
}
