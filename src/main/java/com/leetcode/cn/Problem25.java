package com.leetcode.cn;

import com.book.offer.common.ListNode;

/**
 * Created by wuyuntao on 2024/5/7
 * k个一组翻转链表
 */
public class Problem25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        ListNode finalHead = head;
        ListNode curHead = head;
        ListNode nextHead = head;
        ListNode prevTail = null;
        while(nextHead != null) {
            int count = 1;
            while (count++ <= k) {
                nextHead = nextHead.next;
                if (nextHead == null) {
                    break;
                }
            }
            if (count <= k) {
                return finalHead;
            }
            ListNode tail = curHead;
            ListNode reHead = reverseList(curHead, k);
            if (prevTail == null) {
                finalHead = reHead;
            } else {
                prevTail.next = reHead;
            }
             tail.next = nextHead;
             prevTail = tail;
             curHead = nextHead;
        }
        return finalHead;
    }

    private ListNode reverseList(ListNode head, int k) {
        int count = 1;
        ListNode next = head.next;
        ListNode prev = null;
        while (count++ <= k) {
            head.next = prev;
            prev = head;
            head = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildList(new int[]{1,2,3,4,5,6,7,8,9,10});
        Problem25 problem25 = new Problem25();
        ListNode.printList(problem25.reverseKGroup(head, 7));
    }
}
