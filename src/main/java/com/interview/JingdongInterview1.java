package com.interview;

/**
 * 输入一个字符串，返回第一个仅出现一次的字符
 * Created by wuyuntao on 2021/12/16
 */
public class JingdongInterview1 {

    public static void main(String[] args) {
        String str = "goolle";
        System.out.println(getFirstSingleCharator(str));
    }

    private static String getFirstSingleCharator(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        int len = str.length();
        int[] help = new int[256];
        for (int i = 0; i < len; i++) {
            help[str.charAt(i)]++;
        }
        for (int i = 0; i < len; i++) {
            if (help[str.charAt(i)] == 1) {
                return str.charAt(i) + "";
            }
        }
        return null;
    }
}
