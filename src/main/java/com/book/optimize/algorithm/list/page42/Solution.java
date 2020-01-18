package com.book.optimize.algorithm.list.page42;

import com.book.optimize.algorithm.list.Node;

/**
 * Created by yuntao.wu on 2019/9/2.
 * 约瑟夫环
 */
public class Solution {


    public Node josephusKill(Node head, int k) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node prev = head.getNext();
        while(prev.getNext() != head) {
            prev = prev.getNext();
        }
        int count = 0;
        while(head != head.getNext()) {
            if (++count == k) {
                prev.setNext(head.getNext());
                count = 0;
            } else {
                prev = prev.getNext();
            }
            head = head.getNext();
        }
        return head;
    }


    public Node josephuKillPro(Node head , int k) {
        if (head == null || head.getNext() == head || k < 1) {
            return head;
        }
        Node node = head;
        int tmp = 1;
        while(node.getNext() != head) {
            node = node.getNext();
            ++tmp;
        }
        tmp = getLive(tmp, k);
        while(--tmp != 0) {
            head = head.getNext();
        }
        head.setNext(head);
        return head;
    }

    private int getLive(int num, int k) {
        if (num == 1) {
            return 1;
        }
        return (getLive(num-1,k) + k -1)%num +1;
    }





    public static void main(String[] args) {
        Solution solution = new Solution();
        Node head = Node.buildNodeList(7);
        Node.printNodeList(head);

        Node last = head.getNext();
        while(last.getNext() != null) {
            last = last.getNext();
        }
        last.setNext(head);

        //System.out.println(solution.josephusKill(head,3).getVal());

        /*head = Node.buildNodeList(7);
        last = head.getNext();
        while(last.getNext() != null) {
            last = last.getNext();
        }
        last.setNext(head);*/

        System.out.println(solution.josephuKillPro(head,3).getVal());


    }
}
