package com.book.offer.interview11;

/**
 * Created by Acer on 2020/1/23.
 * 数值的整数次方
 */
public class Solution {
    private boolean invalidInput = false;

    private double power(double base, int exponent) {
        // CASE 1
        if (isEquals(base) && exponent < 0) {
            invalidInput = true;
            return 0.0;
        }
        boolean isNagtive = false;
        long exp = exponent;
        if (exponent < 0) {
            isNagtive = true;
            // CASE 3
            exp = -exp;
        }
        double result = getPower(base, exp);
        return isNagtive? 1/result : result;
    }

    private boolean isEquals(double val) {
        // CASE 2
        if (Math.abs(val) < 0.0000001d ) {
            return true;
        }
        return false;
    }

    private double getPower(double base, long exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double val = getPower(base, exponent >> 1);
        val *= val;
        if ((exponent&1) == 1) {
            val *= base;
        }
        return val;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double result = solution.power(3.1, 3);
        System.out.println(solution.invalidInput);
        System.out.println(result);

        result = solution.power(0, -1);
        System.out.println(solution.invalidInput);
        System.out.println(result);
    }
}
