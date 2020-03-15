package com.book.offer.interview45;

import com.book.offer.common.ListNode;

/**
 * Created by yuntao.wu on 2020/3/14.
 * 圆圈最后剩下的数字
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastOne(7,9));
        System.out.println(solution.lastOne2(7,9));
        System.out.println(solution.lastOne3(7,9));

    }

    private int lastOne(int n ,int m) {
        if (n < 1 || m < 1) {
            return -2;
        }
        ListNode head = buildList(n);
        ListNode node = head;
        ListNode before = null;
        int total = n;
        while (total-- > 1) {
            int count = 1;
            // find the next one
            while (count++ < m) {
                if (node.next == null) {
                    before = node;
                    node = head;
                    continue;
                }
                before = node;
                node = node.next;
            }
            // del the one
            if (node == head) {
                head = head.next;
                node = head;
                continue;
            }
            before.next = node.next;
            node = node.next == null? head : node.next;
        }
        return node.val;
    }


    private ListNode buildList(int n) {
        ListNode after = null;
        int i = n;
        while (i > 0) {
            ListNode node = new ListNode(i, after);
            after = node;
            i--;
        }
        return after;
    }


    // 以0为起点
    private int lastOne2(int n ,int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int lastVal = 0;
        for (int i = 2; i <= n; i++) {
            lastVal = (lastVal + m) % i;
        }
        return lastVal+1;
    }

    // 以1为起点
    private int lastOne3(int n ,int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int lastVal = 1;
        for (int i = 2; i <= n; i++) {
            lastVal = (lastVal + m) % i;
            if (lastVal == 0) {
                lastVal = i;
            }
        }
        return lastVal;
    }

}
