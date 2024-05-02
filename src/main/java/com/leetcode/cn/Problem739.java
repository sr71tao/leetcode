package com.leetcode.cn;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by wuyuntao on 2024/5/2
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 1,1,-4, -2, 4, 3
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100

 */
public class Problem739 {

    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) {
            return null;
        }
        int[] answer = new int[temperatures.length];
        int[] next = new int[101]; // 每个温度最早出现的下标
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = temperatures.length -1; i >= 0; i--) {
            int minIdx = Integer.MAX_VALUE;
            for (int temp = temperatures[i] + 1; temp <= 100; temp++) {
                if (next[temp] < minIdx) {
                    minIdx = next[temp];
                }
            }
            if (minIdx != Integer.MAX_VALUE) {
                answer[i] = minIdx - i;
            }
            next[temperatures[i]] = i;
        }
        return answer;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        if (temperatures == null) {
            return null;
        }
        int[] answer = new int[temperatures.length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (true) {
                if (stack.isEmpty()) {
                    stack.addLast(i);
                    break;
                }
                Integer lastIdx = stack.getLast();
                if (temperatures[lastIdx] >= temperatures[i]) {
                    stack.addLast(i);
                    break;
                } else {
                    answer[lastIdx] = i - lastIdx;
                    stack.pollLast();
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Problem739 problem = new Problem739();
        int[] tempt = new int[]{73,74,75,71,69,72,76,73};
        int[] answer = problem.dailyTemperatures(tempt);
        Arrays.stream(answer).forEach(e -> System.out.print(e + " "));
        System.out.println();


        answer = problem.dailyTemperatures2(tempt);
        Arrays.stream(answer).forEach(e -> System.out.print(e + " "));
        System.out.println();

    }
}
