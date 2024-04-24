package com.book.offer.version2.interview3;

import java.util.Arrays;

/**
 * Created by wuyuntao on 2024/4/21
 * 数组中的重复数字
 */
public class Solution {

    // 空间复杂度O(1), 数字范围(0~n-1)
    private static int duplicateNum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -2;
        }
        boolean invalid = Arrays.stream(arr).anyMatch(e -> e < 0 || e >= arr.length);
        if (invalid) {
            return -2;
        }

        for (int idx=0; idx < arr.length; idx++) {
            if (arr[idx] == idx) {
                print(idx, arr);
                continue;
            }
            while (arr[idx] != idx) {
                int val = arr[idx];
                if (arr[val] == arr[idx]) {
                    print(idx, arr);
                    return val;
                }
                // swap()
                arr[idx] ^= arr[val];
                arr[val] ^= arr[idx];
                arr[idx] ^= arr[val];
                print(idx, arr);
            }
        }

        return -1;
    }

    // 题2: 不能修改原数组，数字范围(1~n-1)，且空间复杂度小于O(n)
    private static int duplicateNum2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -2;
        }
        int max = arr.length-1;
        int min = 1;
        while(min < max) {
            int mid = (max + min)/2;
            int leftCount = mid-min+1;
            if (leftCount < countRange(arr, min, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        // countRange(arr, min, max)
        return min;
    }

    private static int countRange(int[] arr, int start, int end) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>= start && arr[i] <= end) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,1,0,4,0,2,6};
        System.out.println(duplicateNum(arr));

        arr = new int[]{5,2,1,3,6,7,2,4};
        System.out.println(duplicateNum2(arr));
    }

    private static void print(int idx , int[] arr) {
        System.out.print(String.format("index: %d arr:", idx));
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
