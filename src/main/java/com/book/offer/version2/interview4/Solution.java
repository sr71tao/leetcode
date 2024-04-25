package com.book.offer.version2.interview4;

/**
 * Created by wuyuntao on 2024/4/24
 * 二维数组从左到右 从上到下顺序递增，给定一个整数 判断是否包含了该数组
 */
public class Solution {


    private static boolean searchNum(int[][] arr, int target) {
        if (arr == null || arr[0] == null) {
            return false;
        }
        if (arr[0][0] > target || arr[arr.length-1][arr[0].length-1] < target) {
            return false;
        }
        int xLen = arr.length;
        int yLen = arr[0].length;
        int y = yLen -1, x = 0;
        while(y >= 0 && x < xLen) {
            int val = arr[x][y];
            if (val == target) {
                return true;
            } else if (val < target) {
                ++x;
                System.out.println(String.format("down val:%d, x:%d, y:%d", val, x, y));
            } else {
                --y;
                System.out.println(String.format("left val:%d, x:%d, y:%d", val, x, y));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {7, 8, 11, 15}
        };

        System.out.println(searchNum(arr, 6));
    }
}
