package com.book.offer.interview41;

import java.util.stream.IntStream;

/**
 * Created by yuntao.wu on 2020/3/12.
 * 和为s的两个数字&连续正数序列
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,2,4,7,11,15};
//        solution.findNums(arr, 15);

        solution.findSequence(13);
        solution.findSequence(0);
        solution.findSequence(4);

    }


    private void findNums(int[] arr, int num) {
        if (arr == null || arr.length < 2 || arr[0] > num) {
            System.out.println("参数不服条件");
            return;
        }
        int start = 0;
        int end = arr.length-1;
        boolean flag = false;
        while (start < end) {
            int result = arr[start] + arr[end];
            if (result == num) {
                System.out.println(String.format("start:%s,%s end:%s,%s", start, arr[start], end, arr[end]));
                flag = true;
                break;
            }
            if (result < num) {
                start++;
            } else {
                end--;
            }
        }
        if (!flag) {
            System.out.println("没有符合条件数字");
        }
    }


    private void findSequence(int s) {
        if (s < 3) {
            System.out.println("参数不正确,至少大于3");
            return;
        }
        int max = (s+1) >> 1;
        int start = 1;
        int end = 2;
        int sum = 3;
        boolean flag = false;
        while (end <= max) {
            if (sum == s) {
                flag = true;
                IntStream.range(start, end+1).forEach(System.out::print);
                System.out.println();
            }

            if (sum < s) {
                ++end;
                sum += end;
            } else {
                sum -= start;
                ++start;
            }
        }
        if (!flag) {
            System.out.println("未找到对应的序列化数组");
        }
    }
}
