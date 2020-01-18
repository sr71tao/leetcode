package com.leetcode.problems.array;

/**
 * Created by yuntao.wu on 2019/10/16.
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 */
public class Problem695 {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int maxArea = 0;
        int xlen = grid.length;
        int ylen = grid[0].length;
        for (int i = 0; i < xlen; i++) {
            for (int j = 0; j < ylen; j++) {
                if (grid[i][j] == 1) {
                    int max = getArea(i, j, grid);
                    maxArea = Math.max(maxArea, max);
                }
            }
        }
        return maxArea;
    }

    private int getArea(int x, int y, int[][] grid) {
        if (x >= grid.length || y >= grid[0].length || x <0 || y < 0) {
            return 0;
        }
        if (grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = -1;
        return 1 + getArea(x+1, y, grid) + getArea(x-1, y, grid) + getArea(x,y+1, grid) + getArea(x,y-1, grid);
    }


    public static void main(String[] args) {
        Problem695 solution = new Problem695();
        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(solution.maxAreaOfIsland(grid));
    }
}
