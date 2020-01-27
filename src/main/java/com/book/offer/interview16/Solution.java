package com.book.offer.interview16;

import com.book.offer.common.ListNode;

/**
 * Created by Acer on 2020/1/26.
 * 反转链表并输出头节点
 */
public class Solution {

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.buildList(new int[]{1,2,3,4,5,6,7});
        ListNode.printList(head);
        head = solution.reverse(head);
        ListNode.printList(head);
    }
}

