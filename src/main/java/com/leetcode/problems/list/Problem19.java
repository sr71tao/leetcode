package com.leetcode.problems.list;

/**
 * Created by yuntao.wu on 2019/10/28.
 * Given a linked list, remove the n-th node from the end of list and return its head.
 */
public class Problem19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return null;
        }
        int len = 0;
        ListNode node = head;
        while(node != null) {
            len++;
            node = node.next;
        }
        if (n > len) {
            return null;
        }

        int i = len - n;
        ListNode pre = null;
        node = head;
        while (i-- > 0) {
            pre = node;
            node = node.next;
        }
        if (pre == null) {
            return node.next;
        }
        pre.next = node.next;
        return head;
    }

    public ListNode removeNthFromEndExmaple(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode fast = start;
        ListNode slow = start;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return start.next;

    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
