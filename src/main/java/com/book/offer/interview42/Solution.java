package com.book.offer.interview42;

/**
 * Created by yuntao.wu on 2020/3/13.
 * 翻转单词顺序&左旋字符串
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.revers("  b"));
        System.out.println(solution.reverseLeft("abcdef",0));
        System.out.println(solution.reverseLeft("abcdef",1));
        System.out.println(solution.reverseLeft("abcdef",2));
        System.out.println(solution.reverseLeft("abcdef",6));
        System.out.println(solution.reverseLeft("abcdef",7));
    }

    private String revers(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        char[] arr = str.toCharArray();
        reverseWithIdx(arr,0 ,arr.length-1);
        int startIdx = 0;
        int endIdx = 0;
        while (endIdx < arr.length) {

            if (endIdx == arr.length-1 && arr[endIdx] != ' ') {
                reverseWithIdx(arr, startIdx, endIdx);
                break;
            }
            if (arr[endIdx] != ' ') {
                endIdx++;
                continue;
            }
            if (arr[startIdx] != ' ') {
                reverseWithIdx(arr, startIdx, endIdx-1);
            }
            ++endIdx;
            startIdx = endIdx;

        }
        return String.copyValueOf(arr);
    }

    private void reverseWithIdx(char[] arr, int start, int end) {
        while(start < end) {
            char ch = arr[start];
            arr[start] = arr[end];
            arr[end] = ch;
            start++;
            end--;
        }
    }

    private String reverseLeft(String str, int n) {
        if (str == null || str.length() < 2 || n < 1 || n >= str.length()) {
            return str;
        }
        char[] arr = str.toCharArray();
        reverseWithIdx(arr, 0, n-1);
        reverseWithIdx(arr,n, arr.length-1);
        reverseWithIdx(arr,0, arr.length-1);
        return String.copyValueOf(arr);
    }

}
