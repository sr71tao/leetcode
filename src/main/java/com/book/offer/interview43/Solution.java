package com.book.offer.interview43;

/**
 * Created by yuntao.wu on 2020/3/13.
 * n个骰子的点数
 */
public class Solution {

    private static final int G_MAX = 6;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.getProbability2(4);
    }

    private void getProbability(int num) {
        if (num < 1) {
            return;
        }
        int[] probabilities = new int[G_MAX * num - num + 1];
        compute(num, probabilities);
        double total = Math.pow(G_MAX, num);
        for (int i = num; i <= G_MAX * num ; i++) {
            double ratio = probabilities[i-num] / total;
            System.out.println(String.format("i:%s, ratio:%s", i, ratio));
        }

    }

    private void compute(int num, int[] probabilties) {
        for (int i = 1; i <= G_MAX; i++) {
            recursProbabilty(num, num, i, probabilties);
        }
    }

    private void recursProbabilty(int origin, int current, int sum, int[] probabilities) {
        if (current == 1) {
            probabilities[sum-origin]++;
            return;
        }
        for (int i = 1; i <= G_MAX; i++) {
            recursProbabilty(origin, current-1, sum+i, probabilities);
        }
    }


    // 非递归
    private void getProbability2(int num) {
        if (num < 1) {
            return;
        }
        int[][] probalities = new int[2][G_MAX * num - num + 1];
        for (int i = 1; i <= G_MAX; i++) {
            probalities[0][i-1]++;
        }
        int first = 1;
        // 第k个骰子
        for (int k=2; k <= num; k++) {
            for (int i = k; i <= G_MAX * k ; i++) {
                probalities[first][i-k] = 0;
            }
            // 按结果数循环
            for (int i = k; i <= G_MAX * k ; i++) {
                // 取该数前6位之和
                for (int j = i-1; j >= k-1 && j >= i-6; --j) {
                    probalities[first][i-k] += probalities[1-first][j-k+1];
                }
            }
            first = 1-first;
        }
        double total = Math.pow(G_MAX, num);
        for (int i = num; i <= G_MAX * num ; i++) {
            double ratio = probalities[1-first][i-num] / total;
            System.out.println(String.format("i:%s, ratio:%s", i, ratio));
        }
    }
}
