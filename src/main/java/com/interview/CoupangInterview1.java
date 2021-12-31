package com.interview;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 *
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 *
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 *
 * Created by wuyuntao on 2021/12/23
 */
public class CoupangInterview1 {


    public static void main(String[] args) {
        String[] input = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(compute(input));
    }

    private static int compute(String[] input) {
        if (input == null || input.length < 1) {
            return 0;
        }
        Set<String> operations = new HashSet<>();
        operations.add("*");
        operations.add("/");
        operations.add("-");
        operations.add("+");

        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.parseInt(input[0]));
        int len = input.length;
        int i = 1;
        while (i < len) {
            if (!operations.contains(input[i])) {
                stack.push(Integer.parseInt(input[i++]));
                continue;
            }
            Integer num1 = stack.pop();
            Integer num2 = stack.pop();
            Integer result = computeValue(num2, num1, input[i]);
            stack.push(result);
            i++;
        }
        return stack.pop();
    }

    private static int computeValue(Integer num1, Integer num2, String operation) {
        if ("+".equals(operation)) {
            return num1 + num2;
        } else if ("-".equals(operation)) {
            return num1 - num2;
        } else if ("*".equals(operation)) {
            return num1 * num2;
        }
        return num1 / num2;
    }
}
