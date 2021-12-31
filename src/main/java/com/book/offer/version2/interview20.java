package com.book.offer.version2;

/**
 * 表示数值的字符串
 * Created by wuyuntao on 2021/12/31
 */
public class interview20 {

    public static void main(String[] args) {
        String[] input = new String[]{"+100", "5e2", "-123", "3.14156", "-1E-16", "12e", "1a3.14", "1.2.3", "12e+5.4", ".123", "123.", ".e1", "e1"};
        System.out.println(isValidNumber("1.3333e196"));

        for (String str : input) {
            System.out.println(str + ": " + isValidNumber(str));
        }
    }

    private static boolean isValidNumber(String str) {
        if (str == null || str.length() < 1) {
            return false;
        }
        String[] nums = null;
        if (str.contains("E")) {
            nums = str.split("E");
        } else if (str.contains("e")) {
            nums = str.split("e");
        }
        if (nums != null && nums.length != 2) {
            return false;
        }
        if (nums == null) {
            return checkInnerNumber(checkUnsign(str));
        }
        return checkInnerNumber(checkUnsign(nums[0])) && checkNumber(checkUnsign(nums[1]));
    }

    private static String checkUnsign(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("+") || str.startsWith("-")) {
            str = str.substring(1);
        }
        return str;
    }

    private static boolean checkInnerNumber(String str) {
        String[] nums = null;
        if (str.contains(".")) {
            nums = str.split("\\.");
        }
        if (nums != null && nums.length >= 3) {
            return false;
        }
        if (nums == null || nums.length < 1) {
            return checkNumber(str);
        }
        if ("".equals(nums[0])) {
            return checkNumber(nums[1]);
        }
        if (nums.length == 1) {
            return checkNumber(nums[0]);
        }
        return checkNumber(nums[0]) && checkNumber(nums[1]);
    }

    private static boolean checkNumber(String number) {
        if (number == null || number.length() < 1) {
            return false;
        }
        for (int i = 0; i < number.length(); i++) {
            int num = number.charAt(i) - '0';
            if (num < 0 || num > 9) {
                return false;
            }
        }
        return true;
    }

}
