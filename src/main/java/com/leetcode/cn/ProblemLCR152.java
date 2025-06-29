package com.leetcode.cn;

/**
 * Created by wuyuntao on 2025/5/1
 */
public class ProblemLCR152 {

    public static void main(String[] args) {
        ProblemLCR152 problem = new ProblemLCR152();
        System.out.println(problem.verifyTreeOrder(new int[]{4,9,6,5,8})); // false
        System.out.println(problem.verifyTreeOrder(new int[]{4,6,5,9,8})); // true
        System.out.println(problem.verifyTreeOrder(new int[]{4, 8, 6, 12, 16, 14, 10})); // true
        System.out.println(problem.verifyTreeOrder(new int[]{1, 2, 3, 4, 5})); // true
        System.out.println(problem.verifyTreeOrder(new int[]{3,10,6,9,2})); // false

    }

    public boolean verifyTreeOrder(int[] postorder) {
        return recurVerify(postorder, 0,  postorder.length-1);
    }

    private boolean recurVerify(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int p = start;
        while (p < end) {
            if (postorder[p] > postorder[end]) {
                break;
            }
            p++;
        }
        int m = p-1;
        while(p < end) {
            if (postorder[p] < postorder[end]) {
                break;
            }
            p++;
        }
        return p == end && recurVerify(postorder, start, m) && recurVerify(postorder, m+1, end-1);
    }

}
