package com.book.offer.interview20;

/**
 * Created by Acer on 2020/1/27.
 * 顺时针打印矩阵
 */
public class Solution {

    public void printRang(int[][] arr) {
        if (arr == null || arr.length < 1) {
            return ;
        }
        int xlen = arr.length;
        int ylen = arr[0].length;
        int round = Math.min(xlen, ylen);
        for (int r = 0; 2*r < round; r++) {
            int start = r;
            int endX = xlen-1-r;
            int endY = ylen-1-r;
            for (int j = start; j <= endY; j++) {
                System.out.print(arr[start][j] + " ");
            }
            for (int i = start+1; i <= endX; i++) {
                System.out.print(arr[i][endY] + " ");
            }
            for (int j = endY-1; j >= r && start < endX; j--) {
                System.out.print(arr[endX][j] + " ");
            }
            for (int i = endX-1; i > r && r < endY; i--) {
                System.out.print(arr[i][r] + " ");
            }
        }
    }


    private void print(int[][] arr) {
        if (arr == null || arr.length < 1) {
            return ;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,2,3,4},
                {6,7,8,9},
                {11,12,13,14},
                {15,16,17,18}
        };

        /*int[][] arr = new int[][]{
                {1,2},
                {3,4},
                {5,6},
                {7,8}
        };*/

       /* int[][] arr = new int[][]{
                {1,2,3,4},
                {5,6,7,8}
        };*/
        Solution solution = new Solution();
        solution.print(arr);

        solution.printRang(arr);
    }
}
