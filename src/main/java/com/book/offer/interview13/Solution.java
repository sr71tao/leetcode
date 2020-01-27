package com.book.offer.interview13;

/**
 * Created by Acer on 2020/1/25.
 * O(1)时间删除链表节点
 */
public class Solution {

    private Node head;

    private void delNode(Node delNode) {
        if (head == null || delNode == null) {
            return ;
        }
        if (delNode.next != null) {
            delNode.val = delNode.next.val;
            delNode.next = delNode.next.next;
        } else if (head == delNode) {
            head = null;
        } else {
            Node cur = head;
            Node pre = null;
            while(cur.next != null) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = null;
        }
    }

    private void print() {
        print(head);
    }


    private void print(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        Node head = Node.build(new int[]{1,2});
        solution.head = head;
        Node delNode = head;
        solution.delNode(delNode);
        solution.print();

    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public static Node build(int[] arr) {
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            cur.next = node;
            cur = node;
        }
        return head;
    }
}
