package com.book.optimize.algorithm.list.page73;

import com.book.optimize.algorithm.list.Node;

/**
 * Created by yuntao.wu on 2019/9/12.
 * 删除指定值
 */
public class Solution {

    public Node removeValue1(Node head ,int val) {
        if (head == null) {
            return null;
        }

        Node newHead = head;
        while(newHead != null) {
            if (newHead.getVal() != val) {
                break;
            }
            newHead = newHead.getNext();
        }

        Node cur = newHead.getNext();
        Node pre = newHead;
        while(cur != null) {
            Node next = cur.getNext();
            if (cur.getVal() == val) {
                pre.setNext(next);
            } else {
                pre = cur;
            }
            cur = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node head = Node.buildNodeList(5);
        Node.printNodeList(head);

        head = solution.removeValue1(head, 4);
        Node.printNodeList(head);

        head = Node.buildNodeList(new int[]{1,3,4,5,5,6,6,1,2,2,3,1});
        Node.printNodeList(head);

        head = solution.removeValue1(head, 5);
        Node.printNodeList(head);
    }
}
