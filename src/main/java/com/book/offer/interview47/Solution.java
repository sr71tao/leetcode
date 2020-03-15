package com.book.offer.interview47;

/**
 * Created by yuntao.wu on 2020/3/15.
 * 不用加减乘除的加法
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.plus(123,-333));
    }

    private int plus(int m, int n) {
        int xor = m ^ n;
        int and = m & n;
        int sum = 0;
        while (and != 0) {
            and <<= 1;
            sum = xor ^ and;
            and = xor & and;
            xor = sum;
        }
        return sum;
    }

}
