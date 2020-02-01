package com.book.offer.interview36;

import java.util.Arrays;

/**
 * Created by Acer on 2020/2/1.
 * 数组中的逆序对
 */
public class Solution {

    private int getCount(int[] num) {
        if (num == null || num.length < 2) {
            return 0;
        }
        int[] target = new int[num.length];
        int c = mergeSort(num, target, 0, num.length-1);
        Arrays.stream(num).forEach(e -> System.out.print(e + " "));
        System.out.println();
        return c;
    }


    private int mergeSort(int[] source,int[] tmp, int start, int end) {
        if (start == end) {
            return 0;
        }
        int mid = (start + end) / 2;
        int lc = mergeSort(source,tmp, start, mid);
        int rc = mergeSort(source, tmp, mid+1, end);
        return lc + rc + merge(source, tmp, start, mid, end);
    }

    public int merge(int[] source,int[] tmp, int start, int mid, int end) {
       // int[] target = new int[source.length];
        int count = 0;
        int idx1 = start;
        int idx2 = mid+1;
        int i = start;
        while(idx1 <= mid && idx2 <= end) {
            if (source[idx1] > source[idx2]) {
                count += mid-idx1+1;
                tmp[i++] = source[idx2++];
            } else {
                tmp[i++] = source[idx1++];
            }

        }
        while (idx1 <= mid) {
            tmp[i++] = source[idx1++];
        }
        while (idx2 <= end) {
            tmp[i++] = source[idx2++];
        }
        i = start;
        while(i <=end ) {
            source[i] = tmp[i];
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{7,5,1,6,4,2,3};
        System.out.println(solution.getCount(arr));
        //Arrays.stream(arr).forEach(e -> System.out.print(e + " "));

        System.out.println();
    }
}
