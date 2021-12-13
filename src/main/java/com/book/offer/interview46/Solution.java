package com.book.offer.interview46;

/**
 * 把数字翻译成字符串
 * Created by yuntao.wu on 2021/12/13.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(getTransferCount(1225));
        System.out.println(getTranslationCountStandard(1225));
    }

    private static int getTransferCount(long number) {
        if (number < 0) {
            return 0;
        }
        String str = "" + number;
        return getCountRecur(str, 0);
    }

    private static int getCountRecur(String str, int start) {
        if (start >= str.length()) {
            return 0;
        }
        if (start == str.length() - 1) {
            return 1;
        }
        if (start == str.length() - 2) {
            return allowDoubleNum(str, start) ? 2 : 1;
        }
        int doubleCount = 0;
        int singleCount = getCountRecur(str, start + 1);
        if (allowDoubleNum(str, start)) {
            doubleCount = getCountRecur(str, start + 2);
        }
        return doubleCount + singleCount;

    }

    private static boolean allowDoubleNum(String str, int start) {
        int firstNum = str.charAt(start) - '0';
        int secondNum = str.charAt(start + 1) - '0';
        int count =  firstNum * 10 + secondNum;
        return count >= 10 && count <= 25;
    }

    private static int getTranslationCountStandard(long num) {
        if (num < 0) {
            return 0;
        }
        String str = "" + num;
        int len = str.length();
        int[] help = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            int count = i == len - 1 ? 1 : help[i + 1];
            if (i < len - 1) {
                int firstNum = str.charAt(i) - '0';
                int secondNum = str.charAt(i + 1) - '0';
                int totalNum = firstNum * 10 + secondNum;
                if (totalNum >= 10 && totalNum <= 25) {
                    if (i < len - 2) {
                        count += help[i + 2];
                    } else {
                        count += 1;
                    }
                }
            }
            help[i] = count;
        }
        return help[0];
    }


}
