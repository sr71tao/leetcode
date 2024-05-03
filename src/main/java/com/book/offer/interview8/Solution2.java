package com.book.offer.interview8;

/**
 * Created by wuyuntao on 2024/5/3
 * 旋转数组最小数字
 */
public class Solution2 {

    private static int getMinByRotateArr(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[left] == arr[right] && arr[mid] == arr[right]) {
                return getMinVal(arr, left, right);
            }
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left];
    }

    private static int getMinVal(int[] arr, int left, int right) {
        int min = arr[left];
        for (int i = left+1; i <= right; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,1,2};
//        int[] arr = new int[]{1,1,2,0,1};
        System.out.println(getMinByRotateArr(arr));
    }
}
