package com.book.offer.interview44;

import java.util.Arrays;

/**
 * Created by yuntao.wu on 2020/3/14.
 * 扑克牌顺子
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isContinue(new int[]{6,1,0,4,5}));

    }

    private boolean isContinue(int[] arr) {
        if (arr == null || arr.length != 5) {
            return false;
        }
        // n足够大时才有排序选择的意义
        Arrays.sort(arr);
        int zeroCount = 0;
        int start = 0;
        while (arr[start] == 0) {
            ++zeroCount;
            ++start;
        }
        int before = arr[start++];
        while (start < arr.length) {
            if (arr[start] == before+1) {
                before = arr[start++];
                continue;
            } else if (arr[start] == before) {
                return false;
            }

            zeroCount -= arr[start] - before - 1;
            before = arr[start++];
        }
        return zeroCount >= 0;

    }
}
