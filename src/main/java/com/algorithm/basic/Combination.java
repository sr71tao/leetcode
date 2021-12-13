package com.algorithm.basic;

/**
 * 排列 & 组合
 * Created by yuntao.wu on 2021/12/13.
 */
public class Combination {

    private static final int SIZE = 4;

    public static void main(String[] args) {
        int[] nums = new int[]{9, 3, 6, 5};
//        combiRecursive(nums, 0, "");
        arrangeRecursive(nums, 0, "");
    }

    private static void combiRecursive(int[] nums, int idx, String str) {
        if (str.length() == SIZE) {
            System.out.println(str);
            return;
        }
        if (idx >= nums.length) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            combiRecursive(nums, i + 1, str + nums[i]);
        }

    }

    private static void arrangeRecursive(int[] nums, int idx, String str) {
        if (str.length() == SIZE) {
            System.out.println(str);
            return;
        }
        if (idx >= nums.length) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            arrangeRecursive(nums, idx + 1, str + nums[idx]);
            swap(nums, idx, i);
        }
    }

    private static void swap(int[] nums, int idx1, int idx2) {
        if (nums == null || idx1 == idx2) {
            return;
        }
        nums[idx1] ^= nums[idx2];
        nums[idx2] ^= nums[idx1];
        nums[idx1] ^= nums[idx2];
    }
}
