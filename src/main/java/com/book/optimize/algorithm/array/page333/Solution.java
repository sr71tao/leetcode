package com.book.optimize.algorithm.array.page333;

/**
 * Created by yuntao.wu on 2019/11/4.
 * 正方形矩阵顺时针转动90°，空间复杂度O(1)
 */
public class Solution {


    private void rotate(int[][] arr) {
        if (arr == null) {
            return;
        }

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n-1-i; j++) {
                int cur = arr[i][j];
                int nxt = arr[j][n-i-1];
                // 赋右侧
                arr[j][n-i-1] = cur;

                cur = nxt;
                nxt = arr[n-i-1][n-j-1];
                // 赋下侧
                arr[n-i-1][n-j-1] = cur;

                cur = nxt;
                nxt = arr[n-j-1][i];
                // 赋左侧
                arr[n-j-1][i] = cur;

                cur = nxt;
                // 赋上侧
                arr[i][j] = cur;
            }
        }
    }


    private void rotateExample(int[][] arr) {
        if (arr == null) {
            return;
        }
        int tR = 0;
        int tC = 0;
        int dR = arr.length -1;
        int dC = arr[0].length -1 ;

        while(tR < dR) {
            rotateEdge(arr, tR++, tC++, dR--, dC--);
        }
    }

    private void rotateEdge(int[][] arr, int tR, int tC, int dR, int dC) {
        for (int i = 0; i < dR-tR; i++) {
            int tmp = arr[tR][tC+i];
            arr[tR][tC+i] = arr[dR-i][tC];
            arr[dR-i][tC] = arr[dR][dC-i];
            arr[dR][dC-i] = arr[tR+i][dC];
            arr[tR+i][dC] = tmp;
        }
    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        solution.print(arr);
        System.out.println("==================");

//        solution.rotate(arr);
        solution.rotateExample(arr);
        solution.print(arr);

    }

    private void print(int[][] arr) {
        if (arr == null) {
            return;
        }
        for (int[] row : arr) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
