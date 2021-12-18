package com.interview;

/**
 * 将一个单向链表每个节点按k取模 重新组成新链表，按取模的大小排列
 * Created by wuyuntao on 2021/12/15
 */
public class MicroSoftInterview2 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        Node next = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            next = new Node(nums[i], next);
        }
        Node head = next;
        head = mergeNodeList(head, 3);
        print(head);
    }

    private static Node mergeNodeList(Node head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        Node[] subHead = new Node[k];
        Node[] subTail = new Node[k];
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            int idx = cur.val % k;
            if (subHead[idx] == null) {
                subHead[idx] = cur;
                subTail[idx] = cur;
            } else {
                subTail[idx].next = cur;
                subTail[idx] = cur;
            }
            cur.next = null;
            cur = next;
        }
        for (int i = 0; i < k - 1; i++) {
            subTail[i].next = subHead[i + 1];
        }
        return subHead[0];
    }

    private static void print(Node node) {
        while(node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    private static class Node {
        public int val;
        public Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
