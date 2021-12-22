package com.interview;

/**
 * 给定一个矩阵，从外到里顺时针打印
 * Created by wuyuntao on 2021/12/20
 */
public class DouyinInterview2 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };

        int[][] arr2 = new int[][]{
                {1, 2, 3, 4},
                {10, 11, 12, 5},
                {9, 8, 7, 6}
        };

        int[][] arr3 = new int[][]{
                {1, 2, 3, 4, 5},
                {10, 9, 8, 7, 6}
        };

        int[][] arr4 = new int[][]{
                {1, 2, 3},
                {10, 11, 4},
                {9, 12, 5},
                {8, 7, 6}
        };
        int[][] arr5 = new int[][]{
                {1, 2, 3, 4, 5}
        };
        int[][] arr6 = new int[][]{
                {1},
                {2},
                {3},
                {4},
                {5}
        };
        int[][] arr7 = new int[][]{
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };
        print(arr);
    }


    private static void print(int[][] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }
        int rows = arr.length;
        int cols = arr[0].length;
        int round = (Math.min(rows, cols) + 1) / 2;
        for (int r = 0; r < round; r++) {
            for (int j = r; j <= cols - 1 - r; j++) {
                System.out.print(arr[r][j] + ",");
            }
            for (int i = r + 1; i <= rows - 1 - r; i++) {
                System.out.print(arr[i][cols - 1 - r] + ",");
            }
            int totalR = 2 * r;
            for (int j = cols - 2 - r; j > r && rows - 1 > totalR; j--) {
                System.out.print(arr[rows - 1 - r][j] + ",");
            }
            for (int i = rows - 1 - r; i > r && cols - 1 > totalR; i--) {
                System.out.print(arr[i][r] + ",");
            }
        }
        System.out.println();
    }

}
