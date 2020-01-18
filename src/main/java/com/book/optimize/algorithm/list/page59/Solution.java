package com.book.optimize.algorithm.list.page59;

import com.book.optimize.algorithm.list.Node;

/**
 * Created by yuntao.wu on 2019/9/7.
 * 两个链表相加
 */
public class Solution {


    public Node plusNodes(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node node1 = head1;
        Node node2 = head2;

        node1 = reverse(node1);
        node2 = reverse(node2);

        Node cur1 = node1;
        Node cur2 = node2;
        Node newNode = null;
        int over = 0;
        while(cur1 != null && cur2 != null) {
            Node next1 = cur1.getNext();
            Node next2 = cur2.getNext();
            int sum = cur1.getVal() + cur2.getVal() + over;
            if (sum >= 10) {
                sum -= 10;
                over = 1;
            }else {
                over = 0;
            }
            newNode = new Node(sum, newNode);
            cur1 = next1;
            cur2 = next2;
        }
        if (cur1 != null) {
            newNode = generateContinue(cur1, over,newNode);
        } else if (cur2 != null) {
            newNode = generateContinue(cur2, over,newNode);
        } else if (over == 1) {
            newNode = new Node(over, newNode);
        }
        reverse(node1);
        reverse(node2);
        return newNode;
    }

    private Node reverse(Node head) {
        Node prv = null;
        Node cur = head;
        Node next = null;
        while(cur != null) {
            next = cur.getNext();
            cur.setNext(prv);
            prv = cur;
            cur = next;
        }
        return prv;
    }

    private Node generateContinue(Node cur, int over, Node newNode) {
        while (cur != null) {
            Node next= cur.getNext();
            int sum = cur.getVal() + over;
            if (sum > 9) {
                sum -= 10;
                over = 1;
            } else {
                over = 0;
            }
            newNode = new Node(sum, newNode);
            cur = next;
        }
        if (over == 1) {
            newNode = new Node(1, newNode);
        }
        return newNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node head1 = Node.buildNodeList(new int[]{9,4,7});
        Node.printNodeList(head1);
        Node head2 = Node.buildNodeList(new int[]{6,3});
        Node.printNodeList(head2);

        Node node = solution.plusNodes(head1, head2);
        Node.printNodeList(node);

        Node.printNodeList(head1);
        Node.printNodeList(head2);
    }
}
