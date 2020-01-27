package com.book.offer.interview17;

import com.book.offer.common.ListNode;

/**
 * Created by Acer on 2020/1/26.
 * 合并两个有序链表
 */
public class Solution {


    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        if (head1.val > head2.val) {
            return merge(head2,head1);
        }
        ListNode pre = head1;
        ListNode cur1 = head1.next;
        ListNode cur2 = head2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                pre = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                pre = cur2;
                cur2 = cur2.next;
            }
        }

        if (cur1 != null) {
            pre.next = cur1;
        }
        if (cur2 != null) {
            pre.next = cur2;
        }
        return head1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head1 = ListNode.buildList(new int[]{});
        ListNode head2 = ListNode.buildList(new int[]{});

        ListNode.printList(head1);
        ListNode.printList(head2);

        ListNode newHead = solution.merge(head1, head2);
        ListNode.printList(newHead);
    }
}
