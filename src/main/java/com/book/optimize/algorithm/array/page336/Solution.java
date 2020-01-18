package com.book.optimize.algorithm.array.page336;


import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Created by yuntao.wu on 2019/11/16.
 * 无序数组最小的k个数
 */
public class Solution {

    private List<Integer> getMinList(int[] arr , int k) {
        if (arr == null || arr.length < k || k < 1) {
            return Collections.EMPTY_LIST;
        }

        for (int i = k/2 - 1; i >= 0; i--) {
            ajustHeap(arr, i, k-1);
        }

        for (int i = arr.length - 1; i >= k; i--) {
            if (arr[i] > arr[0]) {
                continue;
            }
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            ajustHeap(arr, 0, k-1);
        }
        return IntStream.range(0,k).map(e -> arr[e]).boxed().collect(toList());
    }


    private void ajustHeap(int[] arr, int start, int end) {

        int num = arr[start];
        for (int j = 2*start+1; j <= end; j =2*j +1) {
            if (j < end && arr[j] < arr[j+1]) {
                ++j;
            }
            if (arr[j] < num) {
                break;
            }
            arr[start] = arr[j];
            start = j;
        }
        arr[start] = num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.getMinList(new int[]{6,0,1,7,5,2}, 3).forEach(e -> System.out.print(e +" "));
        System.out.println();
    }
}
