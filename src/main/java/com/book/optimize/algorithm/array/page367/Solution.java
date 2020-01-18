package com.book.optimize.algorithm.array.page367;

/**
 * Created by yuntao.wu on 2019/11/6.
 * 子数组最大累加和
 */
public class Solution {


    private int maxSum(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            min = Math.min(sum, min);
            result = Math.max(result, sum - min);
        }
        return result;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,-2,3,5,-2,6,-1};
        System.out.println(solution.maxSum(arr));
    }
}
