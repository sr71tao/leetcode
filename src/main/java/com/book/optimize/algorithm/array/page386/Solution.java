package com.book.optimize.algorithm.array.page386;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * Created by yuntao.wu on 2019/11/8.
 * 数组未出现的最小整数
 */
public class Solution {



    private int getMinNum(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num > 0) {
                ++count;
                min = Math.min(min, num);
            }
        }
        if (min > 1 || count == 0) {
            return 1;
        }
        boolean[] countArr = new boolean[count];
        for (int num : arr) {
            if (num > 0 && num < count+1) {
                countArr[num-1] = true;
            }
        }
        for (int i = 0; i < countArr.length; i++) {
            if (!countArr[i]) {
                return i+1;
            }
        }
        return countArr.length + 1;
    }



    public int getminNumExample(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int l = 0;
        int r = nums.length;
        while (l < r) {
            if (nums[l] == l+1) {
                l++;
                System.out.print("l加1, ");
            } else if (nums[l] <= l || nums[l] > r || nums[nums[l] - 1] == nums[l]) {
                nums[l] = nums[--r];
                System.out.print("r减1, ");
            } else {
                int tmp = nums[l];
                nums[l] = nums[nums[l]-1];
                nums[tmp - 1] = tmp;
                System.out.print("交换" + l + "与" + (tmp-1) + ",");
            }
            System.out.print("l:" + l + ", r:" + r + ", nums: ");
            printArr(nums);
        }
        return l+1;
    }




    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getminNumExample(new int[]{4,2,1,2,5}));
    }

    private void printArr(int[] arr) {
        Arrays.stream(arr).forEach( e -> System.out.print(e + " "));
        System.out.println();
    }
}
