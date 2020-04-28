package com.book.offer.version2.interview19;

/**
 * Created by yuntao.wu on 2020/4/26.
 * 实现一个函数用于匹配含. 和* 的正则表达式
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("", "a*"));
        System.out.println(solution.isMatch("aaaaaa", "a.*aaa"));
        System.out.println(solution.isMatch("aaaabbb", "a.*bbb"));
        System.out.println(solution.isMatch("accbbb", "a.*bbb"));
        System.out.println(solution.isMatch("acc", "a.*"));
        System.out.println(solution.isMatch("accb", "a.*c"));
    }

    private boolean isMatch(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return match(str, 0, pattern, 0);
    }


    private boolean match(String str, int idx1, String pattern, int idx2) {
        if (str.length() == idx1 && pattern.length() == idx2) {
            return true;
        }
        if (str.length() != idx1 && pattern.length() <= idx2) {
            return false;
        }

        // 后边一位是*
        if (idx2 < pattern.length()-1 && pattern.charAt(idx2+1) == '*') {
            if (str.length() > idx1 && (str.charAt(idx1) == pattern.charAt(idx2) || (pattern.charAt(idx2) == '.' && str.length() != idx1))) {
                // 1 || >1 || 0
                return match(str, idx1+1, pattern, idx2+2) || checkNnum(str, idx1, pattern, idx2)  || match(str, idx1, pattern,idx2+2) ;
            } else {
                return match(str, idx1, pattern, idx2+2);
            }
        }

        if ((str.length() > idx1 && str.charAt(idx1) == pattern.charAt(idx2)) || (pattern.charAt(idx2) == '.' && str.length() != idx1)) {
            return match(str, idx1+1, pattern,idx2+1);
        }
        return false;
    }

    private boolean checkNnum(String str, int idx1, String pattern, int idx2) {
        boolean flag = false;
        int i = idx1+1;
        while (i < str.length()) {
            if (flag || str.charAt(i) != str.charAt(idx1)) {
                break;
            }
            flag = match(str, i++, pattern, idx2);
        }
        return flag;
    }
}
