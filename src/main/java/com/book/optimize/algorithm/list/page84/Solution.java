package com.book.optimize.algorithm.list.page84;

import com.book.optimize.algorithm.list.Node;

/**
 * Created by yuntao.wu on 2019/9/14.
 * 合并有序链表
 */
public class Solution {


    public Node merge(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        Node head = null;
        if (node1.getVal() <= node2.getVal()) {
            head = node1;
            node1 = node1.getNext();
        } else {
            head = node2;
            node2 = node2.getNext();
        }
        Node node = head;
        while(node1 != null && node2 != null) {
            if (node1.getVal() <= node2.getVal()) {
                node.setNext(node1);
                node1 = node1.getNext();
            } else {
                node.setNext(node2);
                node2 = node2.getNext();
            }
            node = node.getNext();
        }
        node.setNext(node1 != null? node1 : node2);
        return head;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node1 = Node.buildNodeList(5);
        Node node2 = Node.buildNodeList(new int[]{6,7,9,10});
        Node.printNodeList(node1);
        Node.printNodeList(node2);
        Node newNode = solution.merge(node1,node2);
        Node.printNodeList(newNode);
    }
}
