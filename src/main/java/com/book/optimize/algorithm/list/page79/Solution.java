package com.book.optimize.algorithm.list.page79;

import com.book.optimize.algorithm.list.Node;

/**
 * Created by yuntao.wu on 2019/9/13.
 * 单链表排序
 */
public class Solution {

    public Node selectSort(Node node) {
        if (node == null || node.getNext() == null) {
            return node;
        }

        Node newHead = null;
        Node tail = node;
        while(tail.getNext() != null) {
            tail = tail.getNext();
        }

        while(node != newHead) {
            Node pre = null;
            Node cur = node;
            Node min = cur;
            Node minPre = null;
            // 最小值
            while (cur != newHead) {
                if (cur.getVal() < min.getVal()) {
                    min = cur;
                    minPre = pre;
                }
                pre = cur;
                cur = cur.getNext();
            }
            // 替换并加入到尾部
            if (minPre != null) {
                minPre.setNext(min.getNext());
            } else {
                node = min.getNext();
            }
            min.setNext(null);
            tail.setNext(min);
            tail = min;
            // 循环
            newHead = newHead == null ? min : newHead;
        }
        return newHead;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node = Node.buildNodeList(new int[]{1,3,4,5,8,10,2,6,9,4});
        Node.printNodeList(node);
        Node head = solution.selectSort(node);
        Node.printNodeList(head);
    }
}
