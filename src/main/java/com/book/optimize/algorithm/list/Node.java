package com.book.optimize.algorithm.list;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by yuntao.wu on 2019/8/28.
 */
public class Node {
    private int val;
    private Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static void printNodeList(Node head) {
        for (Node node = head; node != null; node = node.getNext()) {
            System.out.print(node.getVal() + " ");
        }
        System.out.println();
    }


    public static Node buildNodeList() {
        Node cur = null, pre = null;
        List<Integer> list = Stream.iterate(1, item -> item+1).limit(8).collect(toList());
        for (Integer elem : list) {
            cur = new Node(elem, pre);
            pre = cur;
        }
        return cur;
    }

    public static Node buildNodeList(int n) {
        Node cur = null, pre = null;
        List<Integer> list = Stream.iterate(n, item -> item-1).limit(n).collect(toList());
        for (Integer elem : list) {
            cur = new Node(elem, pre);
            pre = cur;
        }
        return cur;
    }


    public static Node buildNodeList(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        Node next = null;
        Node cur = null;
        for (int i=nums.length-1; i>=0; i--) {
            cur = new Node(nums[i], next);
            next = cur;
        }
        return cur;
    }
}
