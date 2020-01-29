package com.book.offer.interview22;

import java.util.LinkedList;

/**
 * Created by Acer on 2020/1/29.
 * 两个整数序列,第一个为栈的压入序列,判断第二个是否位弹出序列
 */
public class Solution {

    private boolean isPopSequence(int[] pushNum, int[] popNum) {
        if (pushNum == null || popNum == null || pushNum.length != popNum.length) {
            return false;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (i < pushNum.length) {
            if(stack.isEmpty()) {
                stack.push(pushNum[i++]);
            } else if (stack.peek() == popNum[j]) {
                stack.pop();
                ++j;
            } else {
                stack.push(pushNum[i++]);
            }
        }
        while (!stack.isEmpty() && j < popNum.length) {
            if (stack.pop() != popNum[j++]) {
                return false;
            }
        }
        return stack.isEmpty() && j == popNum.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPopSequence(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
        System.out.println(solution.isPopSequence(new int[]{1}, new int[]{1}));

    }
}
