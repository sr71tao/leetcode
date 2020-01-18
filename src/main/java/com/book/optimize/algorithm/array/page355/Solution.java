package com.book.optimize.algorithm.array.page355;

import java.util.HashMap;

/**
 * Created by yuntao.wu on 2019/9/19.
 * 未排序数组累计和为指定值的子数组最长长度
 */
public class Solution {

    private int getMaxLen(int[] nums,int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxLen = 0;
        HashMap<Integer,Integer> valMap = new HashMap<>();
        valMap.put(0,-1);
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!valMap.containsKey(sum)) {
                valMap.put(sum,i);
            }
            Integer beforeIdx = valMap.get(sum-k);
            if (beforeIdx != null) {
                maxLen = Math.max(maxLen, i - beforeIdx );
            }
        }

        return maxLen;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMaxLen(new int[]{1,3,5,-1,6,-4,8}, 18));
    }
}
