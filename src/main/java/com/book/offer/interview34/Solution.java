package com.book.offer.interview34;

/**
 * Created by Acer on 2020/2/1.
 * 因子只有2,3,5的数字称为丑数,求第n个丑数
 */
public class Solution {

    private long getUgly(int n) {
        if (n < 1) {
            return 0;
        }
        long[] result = new long[n];
        result[0] = 1;
        int ugly2 = 0;
        int ugly3 = 0;
        int ugly5 = 0;
        int i = 1;
        while(i < n) {
            long min = min(result[ugly2]*2, result[ugly3]*3, result[ugly5]*5);
            result[i] = min;
            while(result[ugly2]*2 <= result[i]) {
                ugly2++;
            }
            while(result[ugly3]*3 <= result[i]) {
                ugly3++;
            }
            while (result[ugly5]*5 <= result[i]) {
                ugly5++;
            }
            i++;
        }
        return result[n-1];
    }

    private long min(long r1, long r2, long r3) {
        return Math.min(r3, Math.min(r1, r2));
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getUgly(2));
        System.out.println(solution.getUgly(3));
        System.out.println(solution.getUgly(4));
        System.out.println(solution.getUgly(7));
        System.out.println(solution.getUgly(9));
        System.out.println(solution.getUgly(0));
        System.out.println(solution.getUgly(1500));

    }
}
