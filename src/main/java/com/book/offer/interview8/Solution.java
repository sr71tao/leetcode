package com.book.offer.interview8;

/**
 * Created by Acer on 2020/1/23.
 * 旋转数组最小数字
 */
public class Solution {

    private int getMinByArr(int[] arr) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        int high = arr.length-1;
        int low = 0;
        while(high > low) {
            int mid = (high+low) >> 1;
            if(arr[0] == arr[arr.length-1] && arr[mid] == arr[0]) {
                return getMinBySerial(arr, low, high);
            }
            if (arr[mid] <= arr[arr.length-1]) {
                high = mid;
            } else if (arr[mid] >= arr[0]) {
                low = mid+1;
            }
        }
        return arr[low];
    }

    private int getMinBySerial(int[] arr, int start, int end) {
        int minVal = arr[start];
        for (int i = start; i <= end; i++) {
            minVal = Math.min(minVal, arr[i]);
        }
        return minVal;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] arr = new int[]{3,4,5,6,7,1,2,3};
        int[] arr = new int[]{1,0,1,1,1,1};
        System.out.println(solution.getMinByArr(arr));
    }
}
