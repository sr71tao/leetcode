package com.leetcode.contest.contest54;

import java.util.Arrays;

/**
 * Created by yuntao.wu on 2017/10/15.
 */
public class Solution {

    public int findShortestSubArray(int[] nums) {
        int[] count = new int[50000];
        int[] startIdx = new int[50000];
        Arrays.fill(startIdx,-1);

        for (int i =0; i < nums.length; i++){
            if (startIdx[nums[i]] == -1){
                startIdx[nums[i]] = i;
            }
        }

        int maxCount = 0;
        int minLen = 0;
        int result = Integer.MAX_VALUE;
        for (int i =0 ; i < nums.length; i++){
            if (maxCount <= count[nums[i]]+1){ // 是否有大于当前统计的数字
                minLen = i - startIdx[nums[i]]; // start 0, mid , end

                if (maxCount > count[nums[i]]){   // 长度相等
                    result = minLen != 0 && result > minLen? minLen : result;
                }else {  // 更多
                    result = minLen;
                }
                maxCount = minLen == 0? maxCount : count[nums[i]]+1;

            }
            ++count[nums[i]];
        }

        return result+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.findShortestSubArray(new int[]{-1,1,1,1,2,1}));
    }

}
