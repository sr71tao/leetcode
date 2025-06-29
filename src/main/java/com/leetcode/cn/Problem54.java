package com.leetcode.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wuyuntao on 2025/4/26
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class Problem54 {

    public static void main(String[] args) {
        Problem54 problem = new Problem54();
        problem.spiralOrder(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
        }).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int top = -1, left = -1, bottom = matrix.length, right = matrix[0].length;
        List<Integer> result = new LinkedList<>();
        while (true) {
            for (int i = top + 1, j = left + 1; j < right; j++) {
                result.add(matrix[i][j]);
            }
            top++;
            if (bottom - top <= 1) {
                break;
            }
            for (int i = top + 1, j = right - 1; i < bottom; i++) {
                result.add(matrix[i][j]);
            }
            right--;
            if (right - left <= 1) {
                break;
            }
            for (int i = bottom - 1, j = right - 1; j > left; j--) {
                result.add(matrix[i][j]);
            }
            bottom--;
            if (bottom - top <= 1) {
                break;
            }
            for (int i = bottom - 1, j = left + 1; i > top; i--) {
                result.add(matrix[i][j]);
            }
            left++;
            if (right - left <= 1) {
                break;
            }
        }
        return result;
    }
}
