package com.book.offer.interview31;

/**
 * Created by Acer on 2020/1/31.
 * 连续子数组最大和
 */
public class Solution {

    private int maxSum(int[] num) {
        if (num == null || num.length < 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            if (sum <= 0) {
                sum = num[i];
            } else {
                sum += num[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSum(new int[]{1,-2,3,10,-4,7,2,-5}));
    }
}
