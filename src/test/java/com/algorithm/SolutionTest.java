package com.algorithm;

import com.leetcode.contest.contest50.Solution;
import org.junit.Test;

/**
 * Created by yuntao.wu on 2017/9/17.
 */
public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void validPalindrome(){
        String str = "abcda";
        System.out.println(solution.validPalindrome(str));
    }


    @Test
    public void checkValidString(){
//        String str = "((())()()(*)(*()(())())())()()((()())((()))(*";
//        String str = "((*)(*))(*";
//        String str = "((*)(*)))*)*";
//        String str = "(())(())(((()*()()()))()((()()(*()())))(((*)()";
//        String str = "(((*))(((*)))(((*)";

//        String str = "(((((*(((((*)*(**)))))))))))((((*)))))(((**(*)))(*)";
        String str = "(((((*(((((*)*(**)))))))))))((((*)))))";
        System.out.println(solution.checkValidString(str));
    }
}
