package com.leetcode.problems.string;

/**
 * Created by yuntao.wu on 2019/10/22.
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */
public class Problem5 {


    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String res = null;

        for (int i = len-1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j-i < 3 || dp[i+1][j-1]);

                if (dp[i][j] && (res == null || res.length() < j-i+1)) {
                    res = s.substring(i,j+1);
                }

            }
        }
        return res;
    }


    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int len = s.length();
        boolean[] dp = new boolean[len];
        String res = null;

        for (int i = len-1; i >= 0; i--) {
            for (int j = len-1; j >= i; j--) {
                dp[j] = (s.charAt(i) == s.charAt(j)) && (j-i < 3 || dp[j-1]);

                if (dp[j] && (res == null || res.length() < j-i+1)) {
                    res = s.substring(i,j+1);
                }

            }
        }
        return res;
    }


    public static void main(String[] args) {
        Problem5 problem = new Problem5();
        System.out.println(problem.longestPalindrome2("babad"));
    }
}
