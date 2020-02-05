package com.book.offer.interview38;

/**
 * Created by Acer on 2020/2/2.
 * 数字在排序数组中出现的次数
 */
public class Solution {


    private int getCount(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int begin = firstIndex(nums, target);
        if (begin == -1) {
            return 0;
        }
        int last = lastIndex(nums, target);
        return last - begin + 1;
    }

    private int firstIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid+1;
            } else if (nums[mid] > target) {
                end = mid -1;
            } else {
                if (mid > 0 && nums[mid-1] < target) {
                    return mid;
                }
                if (mid == 0) {
                    return 0;
                }
                end = mid - 1;
            }
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    private int lastIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid+1;
            } else if (nums[mid] > target) {
                end = mid -1;
            } else {
                if (mid < nums.length-1 && nums[mid+1] > target) {
                    return mid;
                }
                if (mid == nums.length-1) {
                    return mid;
                }
                start = mid + 1;
            }
        }

        return nums[start] == target? end : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getCount(new int[]{3,3,3,5,5,6,6}, 6));
    }
}
