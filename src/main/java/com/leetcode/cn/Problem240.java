package com.leetcode.cn;

/**
 * Created by wuyuntao on 2024/5/11
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -10^9 <= matrix[i][j] <= 10^9
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -10^9 <= target <= 10^9
 *
 */
public class Problem240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (matrix[0][0] > target || matrix[rows-1][cols-1] < target) {
            return false;
        }
        int j = cols - 1;
        // 大于- 右侧下&下侧右， 小于-左上&上侧左
        for (int i = 0; i < rows && j >= 0; i++) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                continue;
            }
            for (; j >= 0; j--) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] > target) {
                    continue;
                }
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem240 problem240 = new Problem240();
        int[][] matrix = new int[][]{
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
                {1},
                {3},
                {5}
        };
        System.out.println(problem240.searchMatrix(matrix, 5));
    }
}
