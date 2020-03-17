package com.book.offer.version2.interview13;

import java.util.Arrays;

/**
 * Created by yuntao.wu on 2020/3/16.
 * 机器人从0,0 移动且坐标和不大于指定阈值可到达的格子数
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arrivalNums(3,3,2));
    }


    private int arrivalNums(int row, int col, int thresHold) {
        if (row <= 0 || col <= 0 || thresHold < 0) {
            return 0;
        }
        if (thresHold == 0) {
            return 1;
        }
        boolean[][] arr = new boolean[row][col];
        travel(arr, 0, 0, thresHold);
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     *
     * @param arr
     * @param x 横坐标
     * @param y 纵坐标
     * @param thresHold
     * @return
     */
    private int travel(boolean[][] arr, int x, int y, int thresHold) {
        if (x < 0 || y < 0 || x >= arr[0].length || y >= arr.length) {
            return 0;
        }
        if (arr[x][y] || compute(x,y) > thresHold) {
            return 0;
        }
        arr[x][y] = true;
        return
        travel(arr, x, y-1, thresHold) +
        travel(arr, x+1, y, thresHold) +
        travel(arr, x, y+1, thresHold) +
        travel(arr, x-1, y, thresHold) + 1;
    }

    private int compute(int x, int y) {
        int result = 0;
        while(x > 0) {
            result += x%10;
            x = x/10;
        }
        while(y > 0) {
            result += y%10;
            y = y/10;
        }
        return result;
    }
}
