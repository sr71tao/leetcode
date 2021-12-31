package com.interview;

/**
 * TicTacToe toe = new TicTacToe(3);
 *
 * toe.move(0, 0, 1); -> Returns 0
 * |X| |O|
 * | | | |    // Player 1 makes a move at (2, 2).
 * | | |X|
 *
 * Created by wuyuntao on 2021/12/23
 */
public class CoupangInterview2 {

    public static void main(String[] args) {
        TicTacToe toe = new TicTacToe(3);
        System.out.println(toe.move(0, 0, 1));
        System.out.println(toe.move(0, 2, 2));
        System.out.println(toe.move(2, 2, 1));
        System.out.println(toe.move(1, 1, 2));
        System.out.println(toe.move(2, 0, 1));
        System.out.println(toe.move(1, 0, 2));
        System.out.println(toe.move(2, 1, 1));
    }

    private static class TicTacToe {
        private int n;
        private int[][] grid;

        public TicTacToe(int n) {
            this.n = n;
            grid = new int[n][n];
        }

        private int move(int x, int y, int player) {
            if (x < 0 || y < 0 || x >= n || y >= n) {
                return 0;
            }
            if (grid[x][y] != 0) {
                return 0;
            }
            grid[x][y] = player;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (grid[i][y] != player) {
                    break;
                }
                count++;
            }
            if (count == n) {
                return player;
            }
            count = 0;
            for (int j = 0; j < n; j++) {
                if (grid[x][j] != player) {
                    break;
                }
                count++;
            }
            if (count == n) {
                return player;
            }

            if (x != y && x + y != n - 1) {
                return 0;
            }
            count = 0;
            if (x == y) {
                for (int i = 0; i < n; i++) {
                    if (grid[i][i] != player) {
                        break;
                    }
                    count++;
                }
            }
            if (count == n) {
                return player;
            }
            count = 0;
            if (x + y == n - 1) {
                for (int i = 0; i < n; i++) {
                    if (grid[n - 1 - i][i] != player) {
                        break;
                    }
                    count++;
                }
            }
            return count == n ? player : 0;
        }
    }
}
