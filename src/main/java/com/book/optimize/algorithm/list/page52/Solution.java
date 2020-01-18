package com.book.optimize.algorithm.list.page52;

import com.book.optimize.algorithm.list.Node;

/**
 * Created by yuntao.wu on 2019/9/1.
 */
public class Solution {

    public Node divideNodeList(Node head, int pivot) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node node = head;
        Node sH = null;
        Node sT = null;
        Node mH = null;
        Node mT = null;
        Node bH = null;
        Node bT = null;
        Node next = null;
        while (node != null) {
            next = node.getNext();
            node.setNext(null);
            if (node.getVal() < pivot) {
                if (sH == null) {
                    sH = node;
                    sT = node;
                } else {
                    sT.setNext(node);
                    sT = node;
                }
            } else if (node.getVal() == pivot) {
                if (mH == null) {
                    mH = node;
                    mT = node;
                } else {
                    mT.setNext(node);
                    mT = node;
                }
            } else {
                if (bH == null) {
                    bH = node;
                    bT = node;
                } else {
                    bT.setNext(node);
                    bT = node;
                }
            }
            node = next;
        }
        if (sH != null) {
            sT.setNext(mH == null? bH : mH);
        }
        if (mH != null) {
            mT.setNext(bH);
        }
        return sH != null? sH : mH != null? mH : bH;
    }




    public static void main(String[] args) {
        Node head = Node.buildNodeList(new int[]{9,0,4,5,1});
        Node.printNodeList(head);

        Solution solution = new Solution();
        head = solution.divideNodeList(head, 3);
        Node.printNodeList(head);
    }
}
