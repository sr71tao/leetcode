package com.book.offer.version2.interview47;

/**
 * Created by wuyuntao on 2024/5/4
 * 礼物最大价值
 */
public class Solution2 {

    private static int getGifMaxValue(int[][] gifs) {
        if (gifs == null || gifs.length == 0 || gifs[0].length == 0) {
            return 0;
        }
        int xlen = gifs.length;
        int ylen = gifs[0].length;
        int[] help = new int[ylen];
        for (int i = 0; i < ylen; i++) {
            if (i > 0) {
                help[i] = gifs[0][i] + help[i - 1];
            } else {
                help[i] = gifs[0][0];
            }
        }

        for (int i = 1; i < xlen; i++) {
            for (int j = 0; j < ylen; j++) {
                if (j == 0) {
                    help[j] = gifs[i][j] + help[j];
                } else {
                    help[j] = Math.max(help[j], help[j - 1]) + gifs[i][j];
                }
            }
        }
        return help[ylen - 1];
    }


    public static void main(String[] args) {
        int[][] gifs = new int[][]{
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        System.out.println(getGifMaxValue(gifs));
    }
}
