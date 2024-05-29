package com.leetcode.cn;

import java.util.Arrays;

/**
 * Created by wuyuntao on 2024/5/29
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组
 *  [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *  示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组
 *
 * 提示
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 */
public class Problem209 {

    public int minSubArrayLen(int target, int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum < target) {
            return 0;
        }
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        sum = 0;
        while(end < nums.length) {
            sum += nums[end++];
            if (sum < target) {
                continue;
            }
            minLen = Math.min(minLen, end - start);
            while(start < end) {
                sum -= nums[start++];
                if (sum < target) {
                    break;
                }
                minLen = Math.min(minLen, end - start);
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        Problem209 problem209 = new Problem209();
        System.out.println(problem209.minSubArrayLen(7, new int[]{2,3,1,7,2,4,3}));
    }
}
