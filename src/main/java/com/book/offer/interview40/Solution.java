package com.book.offer.interview40;

/**
 * Created by Acer on 2020/2/5.
 * 数祖中只出现一次的数字
 */
public class Solution {

    private void getSingleNums(int[] nums) {
        if (nums == null || nums.length < 2) {
            return ;
        }
        int result = nums[0];
        for (int i=1; i < nums.length; i++) {
            result ^= nums[i];
        }
        if (result == 0) {
            return;
        }
        int i = 1;
        while ((result&i) == 0) {
            i <<= 1;
        }
        int result1 = 0;
        int result2 = 0;
        for (int num : nums) {
            if ((num&i) == 0) {
                result1 ^= num;
            } else {
                result2 ^= num;
            }
        }
        System.out.println(result1 + " " + result2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.getSingleNums(new int[]{2,4,3,6,3,2,5,5});
    }
}
