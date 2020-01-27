package com.book.offer.common;

/**
 * Created by Acer on 2020/1/26.
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildList(int[] arr) {
        if (arr == null || arr.length < 1) {
            return null;
        }
        ListNode pre = null,cur = null;
        for (int i = arr.length-1; i >= 0; i--) {
            pre = new ListNode(arr[i], cur);
            cur = pre;
        }
        return pre;
    }

    public static void printList(ListNode node) {
        while(node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

}
