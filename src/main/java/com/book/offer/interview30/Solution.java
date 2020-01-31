package com.book.offer.interview30;

import java.util.Arrays;

/**
 * Created by Acer on 2020/1/30.
 * 最小的k个数
 */
public class Solution {

    private int[] getMinKNums(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return null;
        }
        int[] result = new int[k];
        int index = nums.length;
        do {
            if (index > k - 1) {
                index = partition(nums, 0, index - 1);
            } else {
                index = partition(nums, index + 1, nums.length - 1);
            }
        } while (index != k - 1);

        for (int i = 0; i < k; i++) {
            result[i] = nums[i];
        }
        return result;
    }


    private int partition(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }
        int num = arr[start];
        int before = start;
        int after = end;
        while (before < after) {
            while (before < after && num <= arr[after]) {
                after--;
            }
            if (before < after) {
                arr[before++] = arr[after];
            }
            while (before < after && num >= arr[before]) {
                before++;
            }
            if (before < after) {
                arr[after--] = arr[before];
            }
        }
        arr[after] = num;
        return after;
    }

    private int[] getMinKNums2(int[] nums, int k) {
        if (nums == null || nums.length < 1 || nums.length < k) {
            return null;
        }
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = nums[i];
        }
        initHeap(arr);
        for (int i = k ; i < nums.length; i++) {
            if (arr[0] < nums[i]) {
                continue;
            }
            arr[0] = nums[i];
            heapAdjust(arr,0);
        }
        return arr;
    }


    private void initHeap(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int idx = arr.length / 2 - 1;
        for (int i = idx; i >= 0; i--) {
            heapAdjust(arr, i);
        }
    }

    private void heapAdjust(int[] arr, int idx) {
        while (idx < arr.length) {
            int subIdx = 2 * idx + 1;
            if (subIdx >= arr.length) {
                break;
            }
            if (subIdx + 1 < arr.length) {
                if (arr[subIdx] < arr[subIdx + 1] && arr[idx] < arr[subIdx + 1]) {
                    swap(arr, idx, subIdx + 1);
                    idx = subIdx + 1;
                } else if (arr[idx] < arr[subIdx]) {
                    swap(arr, idx, subIdx);
                    idx = subIdx;
                } else {
                    break;
                }
            } else if (subIdx < arr.length) {
                if (arr[idx] < arr[subIdx]) {
                    swap(arr, idx, subIdx);
                    idx = subIdx;
                } else {
                    break;
                }
            }
        }


    }

    private void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        int[] result = solution.getMinKNums(arr, 5);
        if (result == null) {
            System.out.println("null");
            return;
        }
        Arrays.stream(result).forEach(value -> System.out.print(value +" "));
        System.out.println();

        result = solution.getMinKNums2(arr,5);
        Arrays.stream(result).forEach(value -> System.out.print(value + " "));
        System.out.println();
    }
}
