package com.book.offer.version2.interview48;

/**
 * 最长不含重复字符子串
 * Created by yuntao.wu on 2021/12/13.
 */
public class Solution {

    private static int[] num = new int[256];
    public static void main(String[] args) {
        for (int i = 0; i < num.length; i++) {
            num[i] = -1;
        }
        String str = "aradfbcacfrbc";
        System.out.println(maxLength(str));
        System.out.println(maxLengthStandard(str));
    }

    private static int maxLength(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        int maxLen = 0;
        int start = 0;
        int end = 0;
        int len = str.length();
        while (end < len) {
            int curIdx = str.charAt(end);
            if (num[curIdx] != -1) {
                int nextStart = num[curIdx];
                while (start <= nextStart) {
                    num[str.charAt(start++)] = -1;
                }
            }
            num[curIdx] = end;
            maxLen = Math.max(maxLen, end - start + 1);
            ++end;
        }
        return maxLen;
    }

    //
    private static int maxLengthStandard(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        int[] position = new int[26];
        for (int i = 0; i < position.length; i++) {
            position[i] = -1;
        }
        int maxLen = 0;
        int curLen = 0;
        int i = 0;
        int length = str.length();
        while (i < length) {
            int prevIdx = position[str.charAt(i) - 'a'];
            if (prevIdx < 0 || i - prevIdx > curLen) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = i - prevIdx;
            }
            position[str.charAt(i) - 'a'] = i;
            ++i;
        }
        return Math.max(maxLen, curLen);

    }

}
