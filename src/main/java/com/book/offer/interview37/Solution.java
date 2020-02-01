package com.book.offer.interview37;

import com.book.offer.common.ListNode;

/**
 * Created by Acer on 2020/2/1.
 * 两个链表的第一个公共节点
 */
public class Solution {

    public ListNode getCommonNode(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return null;
        }
        int len1 = len(node1);
        int len2 = len(node2);
        int gap = Math.abs(len1 - len2);
        int i = 0;
        while (i++ < gap) {
            if (len1 > len2) {
                node1 = node1.next;
            }else {
                node2= node2.next;
            }
        }
        while(node1 != null && node2 != null) {
            if (node1 == node2) {
                return node1;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return null;

    }


    private int len(ListNode node) {
        int len = 0;
        while(node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = ListNode.buildList(new int[]{1,2,3,4,5,6});
        ListNode node2 = ListNode.buildList(new int[]{9,4,7});
        ListNode n1 = node1;
        ListNode n2 = node2;
        while (n2.next != null){
            n2 = n2.next;
        }
        while (n1.val != 6) {
            n1 = n1.next;
        }
        node2.next = n1;

        ListNode res = solution.getCommonNode(node1, node2);
        System.out.println(res == null? "null" : res.val);
    }
}
