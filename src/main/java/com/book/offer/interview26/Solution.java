package com.book.offer.interview26;

/**
 * Created by Acer on 2020/1/29.
 * 复杂链表复制
 */
public class Solution {


    private ListNode clones(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        while(node != null) {
            ListNode copyNode = new ListNode(node.val,node.next);
            node.next = copyNode;
            node = node.next.next;
        }
        node = head;
        while(node != null) {
            ListNode copyNode = node.next;
            copyNode.sibling = node.sibling != null? node.sibling.next : null;
            node = node.next.next;
        }

        node = head;
        ListNode copyHead = node.next;
        while (node != null) {
            ListNode nxt = node.next;
            if (nxt != null) {
                node.next = nxt.next;
            }
            node = nxt;
        }
        return copyHead;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode[] nodes = ListNode.build(new int[]{1,2});
        nodes[1].sibling = nodes[0];

        ListNode copyHead = solution.clones(nodes[0]);

        ListNode tmp = nodes[0];
        while(tmp != null) {
            System.out.print(tmp.val + " s:" + (tmp.sibling != null? tmp.sibling.val+" " : "null "));
            tmp = tmp.next;
        }
        System.out.println();
        tmp = copyHead;
        while(tmp != null) {
            System.out.print(tmp.val + " s:" + (tmp.sibling != null? tmp.sibling.val+" " : "null "));
            tmp = tmp.next;
        }

        System.out.println();
        System.out.println(copyHead == nodes[0]);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode sibling;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode[] build(int[] arr) {
        if (arr.length < 1) {
            return new ListNode[0];
        }
        ListNode[] nodes = new ListNode[arr.length];
        ListNode nxt = null;
        for (int i = arr.length-1; i >=0; i--) {
            nodes[i] = new ListNode(i,nxt);
            nxt = nodes[i];
        }
        return nodes;
    }
}
