package com.leetcode.cn;

import java.util.Arrays;

/**
 * Created by wuyuntao on 2025/4/27
 * 在股票交易中，如果前一天的股价高于后一天的股价，则可以认为存在一个「交易逆序对」。请设计一个程序，输入一段时间内的股票交易记录 record，返回其中存在的「交易逆序对」总数。
 * 0 <= record.length <= 50000
 *
 * 输入：record = [9, 7, 5, 4, 6]
 * 输出：8
 * 解释：交易中的逆序对为 (9, 7), (9, 5), (9, 4), (9, 6), (7, 5), (7, 4), (7, 6), (5, 4)。
 */
public class ProblemLCR170 {

    public static void main(String[] args) {
        ProblemLCR170 problem = new ProblemLCR170();
        System.out.println(problem.reversePairs(new int[]{9, 7, 5, 4, 6}));
    }

    public int reversePairs(int[] record) {
        int[] dest = Arrays.stream(record).toArray();
        return countReverse(record, dest, 0, dest.length-1);
    }

    private int countReverse(int[] ori, int[] dest, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end)/2;
        int cntLeft = countReverse(dest, ori, start, mid);
        int cntRight = countReverse(dest, ori, mid+1, end);
        int cnt = merge(ori, dest, start, mid, mid+1, end);
        System.out.println(String.format("start:%d, end:%d", start, end) + ",cntLeft:" + cntLeft + " cntRight:" + cntRight + " merge:" + cnt);
        return cntLeft + cntRight + cnt;
    }

    private int merge(int[] ori, int[] target, int start1, int end1, int start2, int end2) {
        int idx = start1, count = 0;
        int idx1 = start1, idx2 = start2;
        while (idx1 <= end1 && idx2 <= end2) {
            if (ori[idx1] <= ori[idx2]) {
                target[idx++] = ori[idx1++];
            } else {
                count++;
                target[idx++] = ori[idx2++];
            }
        }
        while(idx1 <= end1) {
            target[idx++] = ori[idx1++];
        }
        while(idx2 <= end2) {
            target[idx++] = ori[idx2++];
        }
        return count;
    }
}
