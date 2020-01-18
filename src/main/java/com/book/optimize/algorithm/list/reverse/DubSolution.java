package com.book.optimize.algorithm.list.reverse;

import com.book.optimize.algorithm.list.Node;

import static com.book.optimize.algorithm.list.Node.buildNodeList;
import static com.book.optimize.algorithm.list.Node.printNodeList;


/**
 * 单链表部分反转
 * Created by yuntao.wu on 2019/8/27.
 */
public class DubSolution {

    public static Node reversePart(Node head, int from, int to) {
        int len = 0;
        Node sPre = null;
        Node sLst = null;
        Node node = head;
        while(node != null) {
            ++len;
            sPre = len == from-1? node : sPre;
            sLst = len == to+1 ? node : sLst;
            node = node.getNext();
        }
        if (from < 1 || to > len || from > to) {
            return head;
        }
        Node pre = sLst;
        Node cur = sPre == null? head : sPre.getNext();
        Node nxt = null;
        while (cur != sLst) {
            nxt = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = nxt;
        }
        if (sPre == null) {
           return pre;
        }
        sPre.setNext(pre);
        return head;
    }

    public static void main(String[] args) {
        Node head = buildNodeList(6);
        printNodeList(head);
        System.out.println("=====================");
        head = reversePart(head, 2, 4);
        printNodeList(head);
        System.out.println("=====================");
        head = reversePart(head, 1, 4);
        printNodeList(head);
    }

}