package com.model;

/**
 * Created by wuyuntao on 2025/4/24
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode build(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode tail = null;
        for (int idx = arr.length-1; idx >= 0; idx--) {
            ListNode node = new ListNode(arr[idx], tail);
            tail = node;
        }
        return tail;
    }

    public static void print(ListNode node) {
        ListNode cur = node;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();

    }
}



