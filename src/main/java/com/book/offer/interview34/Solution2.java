package com.book.offer.interview34;

/**
 * Created by wuyuntao on 2024/5/5
 */
public class Solution2 {


    private static int uglyNum(int num) {
        if (num <= 0) {
            return 0;
        }
        int[] uglyArr = new int[num + 1];
        uglyArr[0] = 1;
        int ugly2Idx = 0, ugly3Idx = 0, ugly5Idx = 0;
        int idx = 1, curUglyNum = 1;
        while(idx < uglyArr.length) {
            while (curUglyNum >= uglyArr[ugly2Idx] * 2) {
                ugly2Idx++;
            }
            while (curUglyNum >= uglyArr[ugly3Idx] * 3) {
                ugly3Idx++;
            }
            while(curUglyNum >= uglyArr[ugly5Idx] * 5) {
                ugly5Idx++;
            }
            curUglyNum = Math.min(uglyArr[ugly2Idx] * 2, Math.min(uglyArr[ugly3Idx] * 3, uglyArr[ugly5Idx] * 5));
            uglyArr[idx++] = curUglyNum;
        }
        return uglyArr[uglyArr.length - 1];

    }

    public static void main(String[] args) {
        System.out.println(uglyNum(1500));
    }
}
