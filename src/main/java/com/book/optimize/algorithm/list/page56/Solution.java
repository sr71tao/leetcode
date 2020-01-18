package com.book.optimize.algorithm.list.page56;

import com.book.optimize.algorithm.list.ComNode;

/**
 * Created by yuntao.wu on 2019/9/6.
 * 复制含有随机节点引用的链表
 */
public class Solution {


    public ComNode copyWithRand(ComNode head) {
        if (head == null) {
            return null;
        }
        ComNode node = head;
        ComNode next = null;
        while (node != null) {
            next = node.next;
            ComNode copy = new ComNode(node.val, next);
            node.next = copy;
            node = next;
        }
        ComNode.printNodeList(head);


        node = head;
        ComNode copy = null;
        while (node != null) {
            copy = node.next;
            next = copy.next;
            if (node.rand != null) {
                copy.rand = node.rand.next;
            }
            node = next;
        }

        node = head;
        ComNode copyHead = head.next;
        while(node != null) {
            next = node.next;
            if (next != null) {
                node.next = next.next;
            }
            node = next;
        }
        return copyHead;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        ComNode[] nodes = ComNode.buildNodeArr(7);
        nodes[1].rand = nodes[5];
        nodes[4].rand = nodes[6];
        nodes[5].rand = nodes[1];

        ComNode.printNodeList(nodes[0]);
        ComNode node = solution.copyWithRand(nodes[0]);
        ComNode.printNodeList(node);
        System.out.println(node.next.rand.val);
        System.out.println(node.next.rand.rand.val);
//        System.out.println();

    }
}
