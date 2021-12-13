package com.algorithm.basic;

import java.util.Arrays;

/**
 * 堆排
 * Created by yuntao.wu on 2021/12/13.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 7, 5, 8, 10, 4, 2};

        heapSort(nums);
        Arrays.stream(nums).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }


    private static void heapSort(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        for (int i = nums.length/2 - 1; i >= 0; i--) {
            heapAdjust(nums, i, nums.length - 1);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapAdjust(nums, 0, i - 1);
        }
    }

    // 大顶堆
    private static void heapAdjust(int[] nums, int idx, int end) {
        if (idx >= nums.length) {
            return;
        }
        int target = nums[idx];
        for (int i = 2 * idx + 1; i <= end; i = 2 * i + 1) {
            if (i + 1 <= end && nums[i] < nums[i + 1]) {
                ++i;
            }
            if (nums[i] < target) {
                break;
            }
            nums[idx] = nums[i];
            idx = i;
        }
        nums[idx] = target;
    }

    private static void swap(int[] nums, int idx1, int idx2) {
        if (idx1 == idx2) {
            return;
        }
        nums[idx1] ^= nums[idx2];
        nums[idx2] ^= nums[idx1];
        nums[idx1] ^= nums[idx2];
    }
}
