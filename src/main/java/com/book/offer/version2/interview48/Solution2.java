package com.book.offer.version2.interview48;

/**
 * Created by wuyuntao on 2024/5/5
 * 最长不含重复字符的子字符串
 */
public class Solution2 {

    private static int getMaxLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int begin = 0, end = 0, max= 0;
        int[] help = new int[26];
        while (end < str.length()) {
            char ch = str.charAt(end++);
            if (help[ch - 'a'] == 0) {
                help[ch - 'a'] = 1;
                max = Math.max(max, end - begin);
                continue;
            }
            while(begin < end) {
                char bch = str.charAt(begin++);
                if (bch == ch) {
                    break;
                }
                help[bch - 'a'] = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getMaxLength("arabcacfr"));
        System.out.println(getMaxLength("aabb"));
    }
}
