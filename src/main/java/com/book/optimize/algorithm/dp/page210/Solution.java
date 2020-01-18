package com.book.optimize.algorithm.dp.page210;


/**
 * Created by yuntao.wu on 2019/11/24.con
 * 两字符串的最长公共子序列
 */
public class Solution {


    private String getComMaxList(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() < 1 || str2.length() < 1) {
            return "";
        }
        int[][] dp = new int[str1.length()][str2.length()];
        dp[0][0] = str1.charAt(0) == str2.charAt(0)? 1 : 0;
        for (int j = 1; j < str2.length(); j++) {
            if (str1.charAt(0) == str2.charAt(j)) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = Math.max(dp[0][j-1], dp[0][j]);
            }
        }
        for (int i = 1; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i][0]);;
            }
        }
        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = str1.length() - 1, j = str2.length() - 1;
        for (; i > 0 && j > 0; ) {
            if (dp[i][j] > dp[i - 1][j] && dp[i][j] > dp[i][j - 1]) {
                sb.append(str1.charAt(i));
                --i;
                --j;
            } else if (dp[i][j] == dp[i - 1][j]) {
                --i;
            } else if (dp[i][j] == dp[i][j - 1]) {
                --j;
            }
        }
        for (; i > 0; i--) {
            if (dp[i][j] > dp[i-1][j]) {
                sb.append(str1.charAt(0));
                break;
            }
        }
        for (; j > 0; j--) {
            if (dp[i][j] > dp[i][j - 1]) {
                sb.append(str2.charAt(j));
                break;
            }
        }
        if (i == 0 &&  j == 0 && dp[i][j] == 1) {
            sb.append(str2.charAt(0));
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getComMaxList("1A2C3D4", "11D23C4"));
    }
}
