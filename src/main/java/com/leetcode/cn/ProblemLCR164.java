package com.leetcode.cn;

import java.util.Arrays;

/**
 * Created by wuyuntao on 2025/5/31
 * 闯关游戏需要破解一组密码，闯关组给出的有关密码的线索是：
 *
 * 一个拥有密码所有元素的非负整数数组 password
 * 密码是 password 中所有元素拼接后得到的最小的一个数
 * 请编写一个程序返回这个密码。
 *
 * 示例 1：
 *
 * 输入：password = [15, 8, 7]
 * 输出："1578"
 * 示例 2：
 *
 * 输入：password = [0, 3, 30, 34, 5, 9]
 * 输出："03033459"
 * 提示：
 * 0 < password.length <= 100
 */
public class ProblemLCR164 {

    public static void main(String[] args) {
        ProblemLCR164 problem = new ProblemLCR164();
        System.out.println(problem.crackPassword(new int[]{12,121}));
    }

    public String crackPassword(int[] password) {
        String[] arr = new String[password.length];
        for (int i = 0; i < password.length; i++) {
            arr[i] = String.valueOf(password[i]);
        }
//        Arrays.sort(arr, this::checkVal);
        Arrays.sort(arr, (x, y) -> (x+y).compareTo(y+x));
        return String.join("", arr);
    }

    private int checkVal(String s1, String s2) {
        int i =0;
        while(i < s1.length()&& i < s2.length()) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return 1;
            } else if (s1.charAt(i) < s2.charAt(i)) {
                return -1;
            }
            i++;
        }
        String res1 = s1 + s2;
        String res2 = s2 + s1;
        for (; i < res1.length(); i++) {
            if (res1.charAt(i) > res2.charAt(i)) {
                // s1 > s2
                return 1;
            } else if (res1.charAt(i) < res2.charAt(i)) {
                // s1 < s2
                return -1;
            }
        }
        return 0;

    }
}
