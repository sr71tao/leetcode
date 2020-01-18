package com.book.optimize.algorithm.list.page71;

import com.book.optimize.algorithm.list.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuntao.wu on 2019/9/12.
 * 删除重复节点
 */
public class Solution {


    public Node removeRepeat1(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Set<Integer> set = new HashSet();
        Node cur = head;
        Node pre = null;
        while(cur != null) {
            if(set.contains(cur.getVal())) {
                pre.setNext(cur.getNext());
            } else {
                set.add(cur.getVal());
                pre = cur;
            }
            cur = cur.getNext();
        }
        return head;
    }


    public Node removeRepeat2(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node pre = head;
        while(pre != null && pre.getNext() != null) {
            Node cur = pre.getNext();
            Node node = head;
            while (node != cur) {
                if (node.getVal() == cur.getVal()) {
                    pre.setNext(cur.getNext());
                    break;
                }
                node = node.getNext();
            }
            if (node != cur) {
                continue;
            }
            pre = pre.getNext();
        }
        return head;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        Node head = Node.buildNodeList(new int[]{1,2,3,3,4,4,2,1,1});
        Node.printNodeList(head);


        solution.removeRepeat1(head);
        Node.printNodeList(head);

        head = Node.buildNodeList(new int[]{1,2,3,3,4,4,2,1,1});
        Node.printNodeList(head);
        solution.removeRepeat2(head);
        Node.printNodeList(head);
    }

}
