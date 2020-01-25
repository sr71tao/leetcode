package com.book.offer.interview12;

import java.util.Arrays;

/**
 * Created by Acer on 2020/1/24.
 * 从1打印到最大的n位数
 */
public class Solution {

    StringBuilder sb = new StringBuilder();

    private void printRange(int n) {
        if(n <= 0) {
            return;
        }
        int[] arr = new int[n];
        while(increase(arr)) {
            print(arr);
        }
    }

    private boolean increase(int[] arr) {
        int len = arr.length;
        for (int i = len-1; i >= 0; i--) {
            if (arr[i] == 9) {
                arr[i] = 0;
                continue;
            }
            arr[i]++;
            break;
        }
        long count = Arrays.stream(arr).filter(e -> e==0).count();
        return count != arr.length;
    }

    private void print(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (!flag && arr[i] != 0) {
                flag = true;
            }
            if (flag) {
                sb.append(arr[i]);
            }
        }
        System.out.println(sb.toString());
        sb.delete(0,sb.length());
    }


    private void printRange2(int n) {
        if(n <= 0) {
            return;
        }
        int[] arr = new int[n];
        incrementNum(arr, n, 0);
    }

    private void incrementNum(int[] arr, int n, int index) {
        if (index == n) {
            print(arr);
            return;
        }
        for (int i = 0; i < 10; i++) {
            arr[index] = i;
            incrementNum(arr, n, index+1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.printRange(3);
        // recursive
        solution.printRange2(3);
    }
}
