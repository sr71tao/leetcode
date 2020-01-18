package com.book.optimize.algorithm.dp.page213;

/**
 * Created by yuntao.wu on 2019/11/24.
 * 两字符串的最长公共子串
 */
public class Solution {


    public String getCommonStr(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() < 1 || str2.length() < 1) {
            return "";
        }
        int maxLen = -1;
        String result = "";
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                int idx = 0;
                while (i + idx < str1.length() && j + idx < str2.length()) {
                    if (str1.charAt(i + idx) != str2.charAt(j + idx)) {
                        break;
                    }
                    ++idx;
                    maxLen = Math.max(maxLen, idx);
                    result = maxLen <= idx ? str2.substring(j, j + idx) : result;
                }
            }
        }
        return result;
    }


    public String getCommonStrDP(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() < 1 || str2.length() < 1) {
            return "";
        }
        int[][] arr = new int[str1.length()][str2.length()];
        int maxLen = 0;
        String result = "";
        for (int i =0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) != str2.charAt(j)) {
                     continue;
                }
                arr[i][j] = 1;
                arr[i][j] += j < 1? 0 : arr[i-1][j-1];
                maxLen = Math.max(maxLen, arr[i][j]);
                result = maxLen <= arr[i][j]? str1.substring(i-maxLen+1, i+1) : result;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getCommonStrDP("1AB234CD", "12345EF"));


    }
}
