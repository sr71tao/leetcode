package com.book.offer.interview35;

/**
 * Created by Acer on 2020/2/1.
 * 第一个只出现一次的字符
 */
public class Solution {

    private char getFirstOne(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        int[] tmp = new int[256];
        for (int i = 0; i < str.length(); i++) {
            tmp[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (tmp[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getFirstOne(""));
    }
}
