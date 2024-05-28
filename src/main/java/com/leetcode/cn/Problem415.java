package com.leetcode.cn;

/**
 * Created by wuyuntao on 2024/5/28
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * 示例 1：
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 *
 * 提示：
 * 1 <= num1.length, num2.length <= 104
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 */
public class Problem415 {

    public String addStrings(String num1, String num2) {
        if (num1 == null) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }
        String max = num1;
        String min = num2;
        if (num1.length() < num2.length()) {
            max = num2;
            min = num1;
        }
        int i = 0, over = 0;
        StringBuilder builder = new StringBuilder();
        while (i < max.length() && i < min.length()) {
            int a = max.charAt(max.length() - i - 1) - '0';
            int b = min.charAt(min.length() - i - 1) - '0';
            builder.append((a+b+over)%10);
            over = a+b+over >= 10? 1: 0;
            ++i;
        }
        while (i < max.length()) {
            int a = max.charAt(max.length() - 1 - i) - '0';
            builder.append((a+over)%10);
            over = a + over >= 10? 1 : 0;
            ++i;
        }
        if (over > 0) {
            builder.append(1);
        }
        return builder.reverse().toString();
    }


    public static void main(String[] args) {
        Problem415 problem415 = new Problem415();
        System.out.println(problem415.addStrings("999999", "11"));
    }
}
