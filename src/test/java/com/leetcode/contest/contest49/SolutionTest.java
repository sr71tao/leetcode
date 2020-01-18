package com.leetcode.contest.contest49;

import org.junit.Test;

/**
 * Created by yuntao.wu on 2017/9/10.
 */
public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void findLengthOfLCIS() {
        int[] nums = new int[]{2,3,3,3,5};
        System.out.println(solution.findLengthOfLCIS(nums));
    }


    @Test
    public void MagicDictionary() {
        solution.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(solution.search("leetcoded"));
    }

    @Test
    public void findNumberOfLIS(){
        System.out.println(solution.findNumberOfLIS(new int[]{}));
    }
}
