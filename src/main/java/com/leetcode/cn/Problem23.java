package com.leetcode.cn;

import com.book.offer.common.ListNode;


/**
 * Created by wuyuntao on 2024/5/9
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 */
public class Problem23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode merge = lists[0];
        for (int i=1; i < lists.length; i++) {
            merge = mergeList(merge, lists[i]);
        }
        return merge;
    }


    private ListNode mergeList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(0, null);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }

        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return head.next;
    }


    public static void main(String[] args) {
        Problem23 solution23 = new Problem23();
        int[][] listArr = new int[][]{
                {1,4,5},
                {1,3,4},
//                {1, 1, 3, 4, 4, 5},
                {2,6}
        };
        ListNode[] lists = new ListNode[listArr.length];
        for (int i = 0; i < listArr.length; i++) {
            lists[i] = ListNode.buildList(listArr[i]);
        }
        ListNode.printList(solution23.mergeKLists(lists));
//        ListNode.printList(solution23.mergeList(lists[0], lists[1]));


    }
}
