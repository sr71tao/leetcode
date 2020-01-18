package com.leetcode.problems.string;

/**
 * Created by yuntao.wu on 2019/10/24.
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 */
public class Problem125 {


    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int i = 0;
        int j = s.length()-1;
        while (i <= j) {

            if (!isAlph(s.charAt(i)) && !isNumc(s.charAt(i))) {
                ++i;
                continue;
            }
            if (!isAlph(s.charAt(j)) && !isNumc(s.charAt(j))) {
                --j;
                continue;
            }

            if (s.charAt(i) != s.charAt(j) ) {
                if (isNumc(s.charAt(i)) || isNumc(s.charAt(j))) {
                    return false;
                }
                if ( isAlph(s.charAt(i)) && isAlph(s.charAt(j))  && Math.abs(s.charAt(i) - s.charAt(j)) != 32) {
                    return false;
                }

            }
            ++i;
            --j;
        }
        return true;
    }


    // TODO
    public boolean isPalindromeExample(String s) {
        return false;
    }

    private boolean isAlph(char c) {
        int scase = c - 'a';
        int bcase = c - 'A';
        if ((scase >= 0 && scase <= 25 ) || (bcase >= 0 && bcase <= 25) ) {
            return true;
        }
        return false;
    }

    private boolean isNumc(char c) {
        int ncase = c - '0';
        if (ncase >= 0 && ncase <= 9) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Problem125 problem = new Problem125();
        System.out.println(problem.isPalindrome("ab2a"));

//        System.out.println((char)('Z' + 1));
//        System.out.println('Z' - 'A');
//        System.out.println('z' - 'a');

//        System.out.println(Character.toLowerCase('a'));

        System.out.println(problem.mySqrt(2147483647));
    }



    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int right = (x+1)/2;
        int left = 1;
        while (true) {
            int mid = left + (right-left)/2;
            if (mid > x/mid) {
                right = mid-1;
            } else {
                if ((mid+1) > x/(mid+1)) {
                    return mid;
                }
                left = mid+1;
            }
        }
    }
}
