package com.book.offer.interview49;

/**
 * Created by yuntao.wu on 2020/3/15.
 * 字符串转数字
 */
public class Solution {
    private boolean inValid = false;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strToInt("--"));
        System.out.println(solution.inValid);
        //System.out.println(Integer.valueOf(""));
    }

    private int strToInt(String str) {
        if (str == null || str.length() < 1) {
            inValid = true;
            return 0;
        }
        int i = 0;
        boolean minus = false;
        if (str.charAt(i) == '-') {
            minus = true;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }

        long result = convert(str.substring(i));
        return (int) (minus? -result : result);
    }

    private long convert(String str) {
        if (str.length() < 1) {
            inValid = true;
            return  0;
        }
        long num = 0;
        int i = 0;
        while (i < str.length()) {
            num *= 10;
            char ch = str.charAt(i++);
            if (ch < '0' || ch > '9') {
                inValid = true;
                break;
            }
            num += ch - '0';
        }
        if (inValid) {
            num = 0;
        }
        return num;
    }
}
