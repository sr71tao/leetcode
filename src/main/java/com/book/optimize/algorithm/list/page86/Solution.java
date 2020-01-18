package com.book.optimize.algorithm.list.page86;

import com.book.optimize.algorithm.list.Node;

/**
 * Created by yuntao.wu on 2019/9/14.
 * 左右半区重组链表
 */
public class Solution {

    public Node composeLink(Node node) {
        if (node == null || node.getNext() == null) {
            return node;
        }
        Node leftE = node;
        Node rightE = node.getNext();
        while(rightE.getNext() != null && rightE.getNext().getNext() != null) {
            leftE = leftE.getNext();
            rightE = rightE.getNext().getNext();
        }
        Node rightS = leftE.getNext();
        leftE.setNext(null);
        Node cur1 = node;
        Node cur2 = rightS;
        while(cur1 != null && cur2 != null) {
            Node next1 = cur1.getNext();
            Node next2 = cur2.getNext();
            cur1.setNext(cur2);
            if (next1 != null) {
                cur2.setNext(next1);
            }
            cur1 = next1;
            cur2 = next2;
        }
        return node;
    }




    public static void main(String[] args) {
        Solution solution = new Solution();
        Node head = Node.buildNodeList(6);
        Node.printNodeList(head);
        head = solution.composeLink(head);
        Node.printNodeList(head);
    }

}
