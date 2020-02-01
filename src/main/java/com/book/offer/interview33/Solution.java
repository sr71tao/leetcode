package com.book.offer.interview33;

import java.util.*;

/**
 * Created by Acer on 2020/2/1.
 * 把数组排成最小的数
 */
public class Solution {

    private String getMinValue(int[] num) {
        if (num == null || num.length < 1) {
            return "0";
        }
        List<String> list = new LinkedList<>();
        Arrays.stream(num).forEach(e -> {
            list.add("" + e);
        });
        Collections.sort(list, (o1, o2) -> {
            String first = o1 + o2;
            String second = o2 + o1;
            int len = o1.length() + o2.length();
            int i = 0;
            while (i < len) {
                if (first.charAt(i) == second.charAt(i)) {
                    i++;
                    continue;
                }
                return first.charAt(i) - second.charAt(i);
            }
            return 0;
        });
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMinValue(new int[]{11,42,45,6,15,21}));
    }
}
