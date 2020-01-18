package com.leetcode.cn;

/**
 * Created by yuntao.wu on 2019/12/5.
 * 两有序数组找中位数
 *
 */
public class Problem4 {

    int binatySearch(int[] arr, int m) {
        if (arr == null || arr.length < 1) {
            return -1;
        }

        int start = 0;
        int end = arr.length -1;
        while (start < end) {
            int mid = (start+end)/2;
            if (arr[mid] < m) {
                start = mid+1;
            } else if (arr[mid] > m) {
                end = mid - 1;
            } else {
                end = mid;
            }
        }
        return arr[start] == m? start : -1;
    }

    public int binarySearch(int[] num1, int[] num2) {
        int len1 = num1.length;
        int len2 = num2.length;
        int mid = (len1+len2+1)/2;
        int m = len1/2;

        return -1;
    }

    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        System.out.println(problem4.binatySearch(new int[]{1,2,3,4,6,7,8}, -1));
    }
}
