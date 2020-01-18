package com.book.optimize.algorithm.list.page48;

import com.book.optimize.algorithm.list.Node;

/**
 * Created by yuntao.wu on 2019/9/4.
 */
public class Solution {


    public boolean isPalindromic(Node head) {
        if (head == null || head.getNext() == null) {
            return true;
        }
        Node slow = head;
        Node fast = head;
        while(fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        // slow in middle
        // reverse
        Node rightPrev = slow;
        Node right = slow.getNext();
        Node rightNxt = null;
        slow.setNext(null);

        while(right != null) {
            rightNxt = right.getNext();
            right.setNext(rightPrev);

            rightPrev = right;
            right = rightNxt;
        }

        // diff
        Node rightStart = rightPrev;
        Node leftStart = head;
        boolean flag = true;
        while(leftStart != null && rightStart != null) {
            if(leftStart.getVal() != rightStart.getVal()) {
                flag = false;
                break;
            }
            leftStart = leftStart.getNext();
            rightStart = rightStart.getNext();
        }

        // restore
        Node resPrev = null;
        Node resNode = rightPrev;
        Node resNext = null;
        while(resNode != null) {
            resNext = resNode.getNext();
            resNode.setNext(resPrev);
            resPrev = resNode;
            resNode = resNext;
        }
        return flag;
    }


    public static void main(String[] args) {
        Node head = Node.buildNodeList(new int[]{1,2,2,1});
        Node.printNodeList(head);
        Solution solution = new Solution();
        System.out.println(solution.isPalindromic(head));

        Node.printNodeList(head);
    }
}

