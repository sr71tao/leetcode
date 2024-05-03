package com.book.offer.interview12;

import java.util.stream.IntStream;

/**
 * Created by wuyuntao on 2024/5/3
 */
public class Solution2 {

    private static void printN(int n) {
        if (n < 1) {
            return;
        }
        IntStream.range(1,10).forEach(System.out::println);
        if (n == 1) {
            return;
        }
        int maxLen = 2;
        while(maxLen <= n) {
            for (int i = 1; i < 10; i++) {
                recurPrintN(""+i, maxLen);
            }
            ++maxLen;
        }

    }

    private static void recurPrintN(String s, int len) {
        if (s.length() == len) {
            System.out.println(s);
            return;
        }
        for (int i = 0; i < 10; i++) {
            recurPrintN(s+ i , len);
        }
    }

    public static void main(String[] args) {
        printN(3);
    }
}
