package com.book.offer.interview32;

/**
 * Created by Acer on 2020/2/1.
 * 1到n整数中1出现的次数
 */
public class Solution {


    private long getCount(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                throw new IllegalArgumentException("字符串包含非数字字符");
            }
        }
        return getOneNum(str);
    }

    private long getOneNum(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        int first = str.charAt(0)-'0';
        if (first == 0 && str.length() == 1) {
            return 0;
        } else if (str.length() == 1 && first > 1) {
            return 1;
        }
        // 最高位为1下 1的数目
        long firstNum = 0;
        // 假设 2145
        // 当最高位数大于1,1000-1999
        if (first > 1) {
            firstNum = powerBase10(str.length()-1);
            // 当最高位数等于1时,不足10^(n-1)个
        } else if (first == 1) {
            long base = 0;
            if (str.length() > 1) {
                base = Long.parseLong(str.substring(1));
            }
            firstNum = base + 1;
        }
        // 除最高位其他位数为1的数目,举例 146-2145 中除最高位外位数为1的数目
        long otherNum = first * (str.length()-1) * powerBase10(str.length()-2);
        // 次高位数的递归统计,举例 1-145
        long remainNum = getOneNum(str.substring(1));
        return firstNum + otherNum + remainNum;
    }


    private long powerBase10(int len) {
        long result = 1;
        for (int i = 0; i < len; i++) {
            result *= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getCount("11"));
    }
}
