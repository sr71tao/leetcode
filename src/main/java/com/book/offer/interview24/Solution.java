package com.book.offer.interview24;

/**
 * Created by Acer on 2020/1/29.
 * 判断二叉搜索树的后续遍历
 */
public class Solution {


    private boolean isPostOrder(int[] num, int begin, int end) {
        if (num == null || num.length < 1) {
            return false;
        }
        if (begin >= end) {
            return true;
        }
        int rootVal = num[end];
        int edge = -1;
        boolean firstFlag = false;
        for (int i = begin; i < end; i++) {
            if (!firstFlag && num[i] > rootVal) {
                firstFlag = true;
                edge = i;
            } else if (firstFlag && num[i] < rootVal) {
                return false;
            }
        }
        if (!firstFlag) {
            edge = end;
        }
        return isPostOrder(num, begin, edge-1) && isPostOrder(num, edge, end-1);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{7,4,6,5};
        System.out.println(solution.isPostOrder(arr,0 ,arr.length-1));
    }
}
