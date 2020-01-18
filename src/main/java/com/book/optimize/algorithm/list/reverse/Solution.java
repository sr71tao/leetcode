package com.book.optimize.algorithm.list.reverse;

import com.book.optimize.algorithm.list.Node;

import static com.book.optimize.algorithm.list.Node.buildNodeList;
import static com.book.optimize.algorithm.list.Node.printNodeList;

/**
 * Created by yuntao.wu on 2019/8/27.
 * 链表反转
 */
public class Solution {

    public static Node reverseLinkList(Node head) {
        Node pre = null;
        Node nxt = null;
        Node cur = head;

        while (cur != null) {
            nxt = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = nxt;
        }
        return pre;
    }


    public static void main(String[] args) {
        Node head = buildNodeList();
        printNodeList(head);
        System.out.println("=====================");
        head = reverseLinkList(head);
        printNodeList(head);
        System.out.println("=====================");
        head = reverseLinkList(new Node(5,null));
        printNodeList(head);
    }



}