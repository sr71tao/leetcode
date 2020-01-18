package com.leetcode.problems.string;

/**
 * Created by yuntao.wu on 2019/11/2.
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters
 *
 */
public class Problem647 {

    public int countSubstrings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        boolean[] help = new boolean[s.length()];
        int count = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = s.length()-1; j >= i; j--) {
                if (i == j) {
                    help[j] = true;
                    ++count;
                } else if (s.charAt(j) == s.charAt(i) && (help[j-1] || j-i == 1)) {
                    help[j] = true;
                    ++count;
                } else {
                    help[j] = false;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Problem647 problem = new Problem647();
        System.out.println(problem.countSubstrings("aaa"));
    }
}
