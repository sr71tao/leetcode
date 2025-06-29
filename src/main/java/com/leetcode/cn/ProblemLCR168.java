package com.leetcode.cn;


/**
 * Created by wuyuntao on 2025/6/1
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 说明：丑数是只包含质因数 2、3 和/或 5 的正整数；1 是丑数。
 * 示例 1：
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 提示：
 *
 * 1 <= n <= 1690
 */
public class ProblemLCR168 {

    public static void main(String[] args) {
        ProblemLCR168 problem = new ProblemLCR168();
        System.out.println(problem.nthUglyNumber(10));
    }


    // 更优雅的
    public int  nthUglyNumber(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(arr[idx2]*2, Math.min(arr[idx3]*3, arr[idx5]*5));
            arr[i] = min;
            if (min == arr[idx2]*2) idx2++;
            if (min == arr[idx3]*3) idx3++;
            if (min == arr[idx5]*5) idx5++;
        }
        return arr[n-1];
    }

    public int nthUglyNumber2(int n) {
        if (n <= 3) {
            return n;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        int idx = 1;
        int maxVal = 1;
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
        n -= 1;
        while (n-- > 0) {
            while(arr[idx2]*2  <= maxVal) {
                idx2++;
            }
            while(arr[idx3]*3 <= maxVal) {
                idx3++;
            }
            while(arr[idx5]*5 <= maxVal) {
                idx5++;
            }
            int res2 = arr[idx2] * 2;
            int res3 = arr[idx3] * 3;
            int res5 = arr[idx5] * 5;
            if (res2 <= res3 && res2 <= res5) {
                arr[idx++] = res2;
            } else if (res3 <= res2 && res3 <= res5) {
                arr[idx++] = res3;
            } else {
                arr[idx++] = res5;
            }
            maxVal = arr[idx-1];
            System.out.println("maxVal " + maxVal);
        }
        return maxVal;
    }
}
