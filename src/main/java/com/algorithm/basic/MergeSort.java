package com.algorithm.basic;

import java.util.Arrays;

/**
 * 归并排序
 * Created by yuntao.wu on 2021/12/13.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 9, 7, 5, 1, 2, 7, 10, 4, 2};
//        int[] nums = new int[]{1,1,1,1,0,0,0,0};
//        int[] target = new int[nums.length];
//        mergeSort(nums, target, 0, nums.length - 1);
//        Arrays.stream(target).forEach(e -> System.out.print(e + " "));
//        System.out.println();

        int[] target2 = new int[nums.length];
        int[] source2 = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            target2[i] = nums[i];
            source2[i] = nums[i];
        }
        mergeSort2(source2, target2, 0, nums.length - 1);
        Arrays.stream(target2).forEach(e -> System.out.print(e + " "));
        System.out.println();

    }

    private static void mergeSort(int[] source, int[] target, int start, int end) {
        if (start >= source.length || start > end) {
            return;
        }
        if (start == end) {
            target[start] = source[start];
            return;
        }
        int mid = (start + end) / 2;
        int[] help = new int[source.length];
        mergeSort(source, help, start, mid);
        mergeSort(source, help, mid + 1, end);
        merge(help, target, start, mid, mid+1, end);
    }

    // 最优空间
    private static void mergeSort2(int[] source, int[] target, int start, int end) {
        if (start >= source.length || start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort2(target, source, start, mid);
        mergeSort2(target, source, mid + 1, end);
        merge(source, target, start, mid, mid+1, end);
    }

    private static void merge(int[] source, int[] target, int start1, int end1, int start2, int end2) {
        int i = start1;
        int j = start2;
        int k = start1;
        while (i <= end1 && j <= end2) {
            if (source[i] <= source[j]) {
                target[k++] = source[i++];
            } else {
                target[k++] = source[j++];
            }
        }
        while (i <= end1) {
            target[k++] = source[i++];
        }
        while(j <= end2) {
            target[k++] = source[j++];
        }
    }
}
