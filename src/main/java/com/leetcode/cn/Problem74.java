package com.leetcode.cn;

/**
 * Created by wuyuntao on 2024/5/11
 */
public class Problem74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (matrix[0][0] > target || matrix[rows-1][cols-1] < target) {
            return false;
        }
        int minRow = 0, maxRow = rows-1, minCol = 0, maxCol = cols - 1;
        while(minRow < maxRow) {
            int midRow = (minRow + maxRow) / 2;
            if (matrix[midRow][cols-1] < target) {
                minRow = midRow + 1;
            } else if (matrix[midRow][cols-1] == target) {
                return true;
            } else {
                maxRow = midRow;
            }
        }


        while(minCol < maxCol) {
            int midCol = (minCol + maxCol)/ 2;
            if (matrix[minRow][midCol] < target) {
                minCol = midCol + 1;
            } else if (matrix[minRow][midCol] == target) {
                return true;
            } else {
                maxCol = midCol;
            }
        }
        return matrix[minRow][minCol] == target;
    }


    public static void main(String[] args) {
        Problem74 problem74 = new Problem74();
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println(problem74.searchMatrix(matrix, 11));
    }
}
