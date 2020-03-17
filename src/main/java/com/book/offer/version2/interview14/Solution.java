package com.book.offer.version2.interview14;

/**
 * Created by yuntao.wu on 2020/3/16.
 * 剪绳子
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMaxValue(8,3));
        System.out.println(solution.getMaxValue(56));
        System.out.println(solution.getMaxValueRecur(56));
    }

    private int getMaxValue(int n, int m) {
        if (n < 2 || n < m || m < 2) {
            return 0;
        }
        int[][] result = new int[m+1][n+1];
        // 先计算分割数为2的情况
        // 总长度
        for (int len = 2; len <= n; len++) {
            // 第一段
            for (int cur = 1; cur < len; cur++) {
                result[2][len] = Math.max(result[2][len], cur * (len-cur));
            }
        }

        // 每一层
        for (int lev = 3; lev <= m; lev++) {
            int max = 0;
            // 总长度
            for (int len = lev; len <= n; len++) {
                // 计算该长度下最大值
                for (int cur = 1; cur <= len-lev+1; cur++) {
                    max = Math.max(max, cur * result[lev-1][len-cur]);
                }
                result[lev][len] = max;
            }
        }
        return result[m][n];
    }


    public int getMaxValue(int n) {
        if (n < 2) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }

        int[] result = new int[n+1];
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i/2; j++) {
                max = Math.max(max, result[j] * result[i-j]);
            }
            result[i] = max;
        }
        return result[n];
    }


    public int getMaxValueRecur(int n) {
        if (n < 2) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }

        int count3 = n / 3;
        if (n - 3*count3 == 1) {
            count3--;
        }
        int pow = (int) Math.pow(3, count3);
        int last = n-3*count3 == 0? 1 : n-3*count3;
        int result = pow * last;
//        return (int)Math.pow(3,count3) * (n-3*count3 == 0? 1 : n-3*count3);
        return result;
    }

}
