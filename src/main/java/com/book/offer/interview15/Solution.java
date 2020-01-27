package com.book.offer.interview15;

/**
 * Created by Acer on 2020/1/26.
 * 链表中倒数第K个元素
 */
public class Solution {

    private ListNode getLastKth(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }
        ListNode first = head;
        int i = 0;
        while(i++ < k) {
            if (first == null) {
                return null;
            }
            first = first.next;
        }
        ListNode second = head;
        while(first != null) {
            second = second.next;
            first = first.next;
        }
        return second;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.build(new int[]{1});

        ListNode node = solution.getLastKth(head, 3);
        System.out.println(node == null? "null" : node.val);
    }
}


class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    static ListNode build(int[] num) {
        if (num == null || num.length < 1) {
            return null;
        }
        ListNode head = new ListNode(num[0]);
        ListNode cur;
        ListNode pre = head;
        for (int i =1; i < num.length ; i++) {
            cur = new ListNode(num[i]);
            pre.next = cur;
            pre = cur;
        }
        return head;
    }
}