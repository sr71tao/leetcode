package com.leetcode.cn;

/**
 * Created by wuyuntao on 2025/4/26
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 *
 */
public class Problem48 {

    public static void main(String[] args) {
        Problem48 problem = new Problem48();
        int[][] matrix = new int[][]{
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };

       problem.print(matrix);
       problem.rotate(matrix);
       problem.print(matrix);
    }

    private void print(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println("=========");
    }

    public void rotate(int[][] matrix) {
        int m = (matrix.length + 1)/2;
        int n = matrix.length;
        for (int i = 0;i < m; i++) {
            for (int j = i; j < n-i-1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
}
