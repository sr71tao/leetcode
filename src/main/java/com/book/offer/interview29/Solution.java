package com.book.offer.interview29;

/**
 * Created by Acer on 2020/1/30.
 * 数组中数字超过一半的数字
 */
public class Solution {


    private int getNumByPartition(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int half = nums.length >> 1;
        int index = partition(nums, 0, nums.length-1);
        while (index > half) {
            index = partition(nums, 0, index-1);
        }
        if (!checkInvalid(nums, nums[half])) {
            return 0;
        }
        return nums[half];
    }

    private int partition(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }
        int num = nums[start];
        int i = start+1, j = end;
        while(i < j) {
            while(i < j && num < nums[j]) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while(i < j && num > nums[i]) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }

        return i;
    }

    private int getNum(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != num) {
                if (count == 1) {
                    num = nums[i];
                } else {
                    count--;
                }
            } else {
                count++;
            }
        }
        if (!checkInvalid(nums, num)) {
            return 0;
        }
        return num;
    }

    private boolean checkInvalid(int[] nums, int num) {
        int count = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == num) {
                count++;
            }
            i++;
        }
        return count > (nums.length>>1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,2,2,2,2,1,1,1,1};
        System.out.println(solution.getNum(arr));
        System.out.println(solution.getNumByPartition(arr));
    }
}
