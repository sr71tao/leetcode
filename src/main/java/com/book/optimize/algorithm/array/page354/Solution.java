package com.book.optimize.algorithm.array.page354;

/**
 * Created by yuntao.wu on 2019/9/19.
 * 未排序正数数组累加和为给定值的最长子数组长度
 */
public class Solution {

    private int maxLenOfSubArr(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 0) {
            return 0;
        }
        int maxLen = 0;
        int start = 0;
        int end = 0;
        int sum = 0;
        while(start < nums.length) {
            while(sum < k && end < nums.length) {
                sum += nums[end++];
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, end - start);
                System.out.println("start:" + start + " ,end:" + end + " ,maxLen:" + maxLen);
            }
            sum -= nums[start++];
        }
        return maxLen;
    }


    private int getMaxLength(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 0) {
            return 0;
        }
        int maxLen = 0;
        int left = 0;
        int right = 0;
        int sum = nums[0];
        while (right < nums.length) {
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
                sum -= nums[left++];
            } else if (sum < k) {
                if (++right >= nums.length) {
                    break;
                }
                sum += nums[right];
            } else {
                sum -= nums[left++];
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMaxLength(new int[]{1,2,1,1,1}, 3));
    }
}
