package com.book.optimize.algorithm.array.page331;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by yuntao.wu on 2019/11/14.
 * 转圈打印矩阵
 */
public class Solution {

    private void printRang(int[][] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }
        int rLen = arr.length;
        int cLen = arr[0].length;
        if (rLen == 1) {
            Arrays.stream(arr[0]).forEach(e -> System.out.print(e + " "));
            System.out.println();
            return;
        }
        if (cLen == 1) {
            Arrays.stream(arr).forEach(e -> System.out.print(e[0] +" "));
            System.out.println();
            return;
        }
        int n = 0; // 控制循环次数
        int len = 0;
        while (len < rLen && len < cLen) {
            int bc = n;     // begin col
            int br = n;     // begin row
            int ec = cLen - 1 - n;    // end col
            int er = rLen - 1 - n;    // end row

            // 上
            for (int i = bc; i < ec; i++) {
                System.out.print(arr[br][i] + " ");
            }
            // 右
            for (int i = br; i < er; i++) {
                System.out.print(arr[i][ec] + " ");
            }
            // 下
            for (int i = ec; i > bc; i--) {
                System.out.print(arr[er][i] + " ");
            }
            // 左
            for (int i = er; i > br; i--) {
                System.out.print(arr[i][bc] + " ");
            }
            ++n;
            len += 2;
        }
    }


    private void printRangeExample(int[][] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int tR = 0;
        int tC = 0;
        int dR = nums.length - 1;
        int dC = nums[0].length - 1;

        while(tR <= dR && tC <= dC) {
            print(nums, tR++, tC++, dR--, dC--);
        }
    }

    private void print(int[][] nums, int tR, int tC, int dR, int dC) {
        if (tR == dR) {
            IntStream.rangeClosed(tC,dC).forEach(e -> System.out.print(nums[tR][e] + " "));
            System.out.println();
        } else if (tC == dC) {
            IntStream.rangeClosed(tR,dR).forEach(e -> System.out.print(nums[e][tC] + " "));
            System.out.println();
        } else {
            int curR = tR;
            int curC = tC;
            // up
            while (curC < dC) {
                System.out.print(nums[curR][curC++] + " ");
            }
            // right
            while(curR < dR) {
                System.out.print(nums[curR++][dC] + " ");
            }
            // down
            while (curC > tC) {
                System.out.print(nums[dR][curC--] + " ");
            }
            // left
            while(curR > tR) {
                System.out.print(nums[curR--][tC] + " ");
            }
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = new int[][]{
                {1},
                {2},
                {3},
                {5}
        };
        solution.printRangeExample(arr);
    }
}
