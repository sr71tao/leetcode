package com.leetcode.problems.other;

/**
 * Created by yuntao.wu on 2019/10/30.
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 */
public class Problem29 {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        long pDivided = dividend ;
        long pDivisor = divisor;
        pDivided = pDivided < 0 ? -pDivided : pDivided;
        pDivisor = pDivisor < 0? -pDivisor : pDivisor;
        if (pDivisor > pDivided ) {
            return 0;
        }

        long dnum = pDivided;
        long snum = pDivisor;
        long result = 1;
        while ((dnum-snum) > 0) {
            result <<= 1;
            snum <<= 1;
        }
        if (dnum-snum == 0) {

            if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ) {
                if (result == Integer.MAX_VALUE + 1L) {
                    return Integer.MAX_VALUE;
                }
                return (int)result;
            }
            return (int)-result;
        }
        result >>= 1;
        snum >>= 1;

        result += divide((int)(pDivided - snum), (int)pDivisor);
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ) {
            return (int)result;
        }
        return (int)-result;
    }

    public int divideExample(int dividend, int divisor) {
        boolean negative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);

        long absDividend = Math.abs((long)dividend);
        long absDivisor = Math.abs((long)divisor);
        if (absDividend == 0 || absDividend < absDivisor) {
            return 0;
        }

        long result = 0;
        while(absDividend >= absDivisor) {
            long tmp = absDivisor;
            long count = 1;
            while(absDividend >= tmp) {
                tmp <<= 1;
                count <<= 1;
            }
            absDividend -= tmp >> 1;
            result += count >>= 1;
        }
        return negative? (int) ~result+1 : result > Integer.MAX_VALUE? Integer.MAX_VALUE : (int)result;
    }




    public static void main(String[] args) {
        Problem29 problem = new Problem29();
        /*System.out.println(problem.divide(-2147483648,-1));

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);*/

        int result = 11;
        System.out.println(~result);
    }
}
