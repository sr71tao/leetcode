package com.book.offer.interview28;

/**
 * Created by Acer on 2020/1/30.
 * 输入一个字符串,输出该字符串的所有字符排列
 */
public class Solution {

    private void permtation(String str) {
        if (str == null || str.length() < 1 ) {
            return ;
        }
        recurs("", str);
    }

    private void recurs(String prefix, String subfix) {
        if (subfix == null || subfix.length() < 1) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < subfix.length(); i++) {
            recurs(prefix+subfix.charAt(i), subfix.substring(0,i) + subfix.substring(i+1));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.permtation("acvb");
    }
}
