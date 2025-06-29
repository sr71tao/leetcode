package com.leetcode.cn;

import com.model.ListNode;

/**
 * Created by wuyuntao on 2025/4/24
 *
 * 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 *
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下
 */
public class ProblemLCR77 {

    public static void main(String[] args) {
        ProblemLCR77 problem = new ProblemLCR77();
        ListNode.print(problem.sortList(ListNode.build(new int[]{4,2,1,3})));
    }


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fakeHead = new ListNode(0, head);
        int length = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            length++;
        }

        for (int step = 1; step < length; step = step <<1) {
            ListNode prev = fakeHead, cur = fakeHead.next;
            while(cur != null) {
                ListNode head1 = cur;
                for (int cnt = step-1; cnt > 0 && cur.next != null; cnt--) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int cnt = step-1; cnt > 0 && cur != null && cur.next != null; cnt--) {
                    cur = cur.next;
                }
                ListNode nextHead = null;
                if (cur != null) {
                    nextHead = cur.next;
                    cur.next = null;
                }

                prev.next = merge(head1, head2);
                while(prev.next != null) {
                    prev = prev.next;
                }
                cur = nextHead;
            }
        }

        return fakeHead.next;
    }

    public ListNode merge(ListNode head1,ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode prev = new ListNode(0);
        ListNode fakeHead = prev;
        ListNode cur1 = head1, cur2 = head2;
        while(cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                prev.next = cur1;
                prev = cur1;
                cur1 = cur1.next;
            } else  {
                prev.next = cur2;
                prev = cur2;
                cur2 = cur2.next;
            }
        }
        if (cur1 != null) {
            prev.next = cur1;
        }
        if (cur2 != null) {
            prev.next = cur2;
        }
        return fakeHead.next;
    }

}
