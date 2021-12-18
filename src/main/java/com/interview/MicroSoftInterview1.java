package com.interview;

/**
 * 已排序数组，找出不大于目标数的最大下标
 * Created by wuyuntao on 2021/12/15
 */
public class MicroSoftInterview1 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,3,3,3,3,4};
        System.out.println(findLargestIndex(nums, 2));
    }

    private static int findLargestIndex(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (nums[start] <= target) {
            return start;
        }
        return start - 1;
    }
}
