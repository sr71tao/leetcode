package com.book.optimize.algorithm.list.page68;

import com.book.optimize.algorithm.list.Node;

/**
 * Created by yuntao.wu on 2019/9/8.
 * 链表反转部分
 */
public class Solution {


    public Node partReverse(Node head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        Node left = null;
        Node tail = getNextNode(head, k);
        Node newHead = null;
        while (tail != null) {
            reverse(left, head, tail);
            newHead = newHead == null? tail : newHead;
            left = head;
            head = head.getNext();
            tail = getNextNode(head,k);
        }

        return newHead;
    }


    private Node getNextNode(Node head ,int k) {
        if (head == null || k < 1) {
            return null;
        }
        int i = 1;
        while(i++ < k && head != null) {
            head = head.getNext();
        }
        if (i >= k) {
            return head;
        }
        return null;
    }

    private void reverse(Node left, Node head,Node tail) {
        if (head == null || tail == null) {
            return ;
        }

        Node limit = tail.getNext();
        Node right = limit;
        Node cur = head;
        Node next = null;
        while(cur != limit) {
            next = cur.getNext();
            cur.setNext(right);
            right = cur;
            cur = next;
        }
        if (left != null) {
            left.setNext(right);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node head = Node.buildNodeList(9);
        Node.printNodeList(head);

//        Node tail = solution.getNextNode(head, 3);
//        System.out.println(tail.getVal());
//        solution.reverse(null, head, tail);
//        Node.printNodeList(tail);


        Node newHead = solution.partReverse(head,5);
        Node.printNodeList(newHead);
    }
}
