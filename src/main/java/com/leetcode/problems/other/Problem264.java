package com.leetcode.problems.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuntao.wu on 2019/11/2.
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5
 */
public class Problem264 {

    public int nthUglyNumberExample(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        int index2 = 1, index3 = 1, index5 = 1;
        for (int i = 1; i < n; i++) {
            int num = Math.min(Math.min(factor2, factor3),factor5);
            nums[i] = num;
            if (num == factor2) {
                factor2 = 2 * nums[index2++];
            }
            if (num == factor3) {
                factor3 = 3 * nums[index3++];
            }
            if (num == factor5){
                factor5 = 5 * nums[index5++];
            }
        }
        return nums[n-1];
    }

    public static void main(String[] args) {
        Problem264 problem = new Problem264();
        System.out.println(problem.nthUglyNumberExample(10));
    }
}
