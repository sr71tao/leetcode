package com.leetcode.contest.contest52;

import java.util.Arrays;

/**
 * Created by yuntao.wu on 2017/10/5.
 */
public class Solution {

    public double knightProbability(int N, int K, int r, int c) {
        double result = 1;
        for (int i = 0; i < K; i++){
            result *= 8;
        }
        System.out.println(result);
        return recurive(N,K,r,c,0)/result;
    }

    private int recurive(int N, int K, int r, int c, int k){
        if (r < 0 || r >= N || c < 0 || c >= N){
            return 0;
        }
        if (K == k){
            return 1;
        }
        int count = 0;
        count += recurive(N,K,r-2,c+1, k+1);
        count += recurive(N,K,r-1,c+2, k+1);
        count += recurive(N,K,r+1,c+2, k+1);
        count += recurive(N,K,r+2,c+1, k+1);

        count += recurive(N,K,r+2,c-1, k+1);
        count += recurive(N,K,r+1,c-2, k+1);
        count += recurive(N,K,r-1,c-2, k+1);
        count += recurive(N,K,r-2,c-1, k+1);
        System.out.println(k + " " + count);
        return count;

    }

    public double knightProbaly(int N,int K, int r,int c){
        int[][] moves = new int[][]{{2,-1},{1,-2},{1,2},{2,1},{-1,2},{-2,1},{-2,-1},{-1,-2}};
        double[][] dp0 = new double[N][N];
        for (double[] row : dp0){
            Arrays.fill(row,1);
        }

        for (int k =0; k < K; k++){
            double[][] dp1 = new double[N][N];
            for (int i = 0; i < N; i++){
                for (int j =0; j < N; j++){
                    for (int[] move : moves){
                        int row = i + move[0];
                        int col = j + move[1];
                        if (!(row < 0 || col < 0 || row >= N || col >= N)){
                            dp1[i][j] += dp0[row][col];
                        }
                    }
                }
            }
            dp0 = dp1;
        }
        return dp0[r][c]/Math.pow(8,K);
    }



    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        long[] help = new long[nums.length-k+1];
        int[] result = new int[3];

        int[] leftMax = new int[nums.length-k+1];
        int[] rightMax = new int[nums.length-k+1];

        for (int i =0 ; i < k; i++){
            help[0] += nums[i];
        }
        for (int i = 1; i <= nums.length-k; i++){
            help[i] = help[i-1] - nums[i-1] + nums[i+k-1];
        }

        System.out.println("help:");
        for (long num : help){
            System.out.print(num + " ");
        }
        System.out.println();

        for (int i = 0,maxIdx = 0; i <= nums.length-k; i++){
            if (help[maxIdx] < help[i]){
                maxIdx = i;
            }
            leftMax[i] = maxIdx;
        }

        for (int i = nums.length-k,maxIdx = i; i >= 0; i--){
            if (help[maxIdx] <= help[i] ){
                maxIdx = i;
            }
            rightMax[i] = maxIdx;
        }
        System.out.println("leftMax:");
        printArr(leftMax);
        System.out.println("rightMax:");
        printArr(rightMax);

        long preCount = 0;
        long count = 0;
        for (int i=k; i <= nums.length-2*k; i++){
            if (preCount < (count = help[leftMax[i-k]] + help[i] + help[rightMax[i+k]])){
                result[0] = leftMax[i-k];
                result[1] = i;
                result[2] = rightMax[i+k];
                preCount = count;
            }
        }

        return result;
    }


    // meizuochulai
    public double knightProbability2(int N, int K, int r, int c) {
        int[][] moves = new int[][]{{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
        int len = N;
        double dp0[][] = new double[len][len];
        for(double[] row : dp0) Arrays.fill(row, 1);
        for(int l = 0; l < K; l++) {
            double[][] dp1 = new double[len][len];
            for(int i = 0; i < len; i++) {
                for(int j = 0; j < len; j++) {
                    for(int[] move : moves) {
                        int row = i + move[0];
                        int col = j + move[1];
                        if(isLegal(row, col, len)) dp1[i][j] += dp0[row][col];
                    }
                }
            }
            dp0 = dp1;
        }
        return dp0[r][c] / Math.pow(8, K);
    }
    private boolean isLegal(int r, int c, int len) {
        return r >= 0 && r < len && c >= 0 && c < len;
    }

    private void printArr(int[] nums){
        for (int num : nums){
            System.out.print(num + " ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.knightProbaly(8,30,6,4));

        int[] index = solution.maxSumOfThreeSubarrays(new int[]{7,13,20,19,19,2,10,1,1,19}, 3);
        System.out.println("result:");
        for (int num : index){
            System.out.print(num + " ");
        }

    }
}
