package com.algorithm.basic;

import java.util.Arrays;

/**
 * 快排
 * Created by yuntao.wu on 2021/12/13.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 7, 5, 8, 10, 4, 2};
        quickSort(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    private static void quickSort(int[] nums, int start ,int end) {
        if (start >= end) {
            return;
        }
        int idx = oneQsort(nums, start, end);
        quickSort(nums, start, idx - 1);
        quickSort(nums, idx + 1, end);
    }

    private static int oneQsort(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }
        int target = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= target) {
                --end;
            }
            if (start < end) {
                nums[start++] = nums[end];
            }
            while(start < end && nums[start] <= target) {
                ++start;
            }
            if (start < end) {
                nums[end--] = nums[start];
            }
        }
        nums[start] = target;
        return start;
    }
}
