package com.book.offer.interview14;

import java.util.Arrays;

/**
 * Created by Acer on 2020/1/25.
 * 调整数组顺序使奇数位于偶数前面
 */
public class Solution {

    private void adjust(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int even = arr.length-1;
        int odd = 0;
        while(odd < even && odd< arr.length && even >= 0) {
            if ((arr[odd]&1) == 1) {
                ++odd;
            } else if ((arr[even]&1) == 0) {
                --even;
            } else {
                arr[odd] = arr[odd]^arr[even];
                arr[even] = arr[odd]^arr[even];
                arr[odd] = arr[odd]^arr[even];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{2,4,6,8,0};
        solution.adjust(arr);
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();
    }
}
