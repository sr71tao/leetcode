package com.book.optimize.algorithm.list.page82;

import com.book.optimize.algorithm.list.Node;

/**
 * Created by yuntao.wu on 2019/9/14.
 * 环形有序链表插入新节点
 */
public class Solution {

    public Node insertNode(Node head, int num) {
        if (head == null) {
            Node node = new Node(num,null);
            node.setNext(node);
            return node;
        }

        Node cur = head.getNext();
        Node pre = head;
        while(cur != head) {
            if (pre.getVal() <= num && cur.getVal() >= num) {
                break;
            }
            pre = cur;
            cur = cur.getNext();
        }
        Node node = new Node(num,cur);
        pre.setNext(node);
        return head.getVal() > num? pre.getNext() : head;

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        Node head = Node.buildNodeList(new int[]{3,4,6,7,9});
        Node tail = head;
        while(tail.getNext() != null) {
            tail = tail.getNext();
        }
        tail.setNext(head);
        printNode(head);
        Node newHead = solution.insertNode(head,2);
        printNode(newHead);


    }

    private static void printNode(Node head) {
        if (head == null) {
            return ;
        }
        Node node = head.getNext();
        System.out.print(head.getVal() + " ");
        while(node != head) {
            System.out.print(node.getVal() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
}
