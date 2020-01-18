package com.book.optimize.algorithm.array.page358;

/**
 * Created by yuntao.wu on 2019/9/22.
 * 未排序数组累加和小于或等于给定值的最长子数组
 */
public class Solution {

    private int getMaxLen(int[] nums, int k) {
        if (nums == null || nums.length < 0) {
            return 0;
        }
        int[] sumArr = new int[nums.length+1];
        int[] helperArr = new int[nums.length+1];
        for (int i = 0,sum = 0; i < nums.length; i++) {
            sum += nums[i];
            sumArr[i+1] = sum;
            helperArr[i+1] = Math.max(helperArr[i], sumArr[i+1]);
        }
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int idx = binarySearch(sumArr[i+1]-k, helperArr, i+1);
            System.out.println(sumArr[i+1]-k + " idx:" + idx);
//            int len = idx == -1? 0 : i -idx + 1;
            if (idx != -1) {
                maxLen = Math.max(maxLen,i -idx + 1);
            }
        }
        return maxLen;
    }


    private int binarySearch(int val, int[] helper) {
        return binarySearch(val, helper, helper.length-1);
    }

    private int binarySearch(int val, int[] helper, int size) {
        int min = 0;
        int max = size;
        int idx = -1;
        while(min <= max) {
            int mid = (min + max) >> 1;
            if (helper[mid] == val) {
                idx = mid;
                max = mid-1;
            } else if (helper[mid] > val) {
                idx = mid;
                max = mid-1;
            } else {
                min = mid + 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.binarySearch(10, new int[]{0,3,4,page115,page115,7,8,8,9}));
        System.out.println(solution.getMaxLen(new int[]{3,-2,-4,0,6},-2));
    }
}
