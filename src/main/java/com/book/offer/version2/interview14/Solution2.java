package com.book.offer.version2.interview14;

/**
 * Created by wuyuntao on 2024/5/4
 * 剪绳子
 */
public class Solution2 {

    private static int cutting(int n, int m) {
        if (m < 2 || n < m) {
            return 0;
        }
        return recurCut(n, m, 1);
    }

    private static int recurCut(int n, int m, int result) {
        if (m == 1) {
            return result * n;
        }
        if (n == m) {
            return result;
        }
        int param = result;
        for (int i = 1; i <= n-m+1; i++) {
            result = Math.max(result, recurCut(n-i, m-1, param * i));
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(cutting(4,2));
    }
}
