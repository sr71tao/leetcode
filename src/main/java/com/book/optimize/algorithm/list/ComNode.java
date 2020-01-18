package com.book.optimize.algorithm.list;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by yuntao.wu on 2019/9/6.
 */
public class ComNode {
    public int val;
    public ComNode next;
    public ComNode rand;

    public ComNode(int val, ComNode next) {
        this.val = val;
        this.next = next;
    }


    public static void printNodeList(ComNode head) {
        for (ComNode node = head; node != null; node = node.next) {
            System.out.print(node.val + " ");
        }
        System.out.println();
    }

    public static ComNode buildNodeList(int n) {
        ComNode cur = null, pre = null;
        List<Integer> list = Stream.iterate(n, item -> item-1).limit(n).collect(toList());
        for (Integer elem : list) {
            cur = new ComNode(elem, pre);
            pre = cur;
        }
        return cur;
    }

    public static ComNode[] buildNodeArr(int n) {
        ComNode head = buildNodeList(n);
        ComNode[] nodeArr = new ComNode[n];
        int i = 0;
        while(head != null) {
            nodeArr[i++] = head;
            head = head.next;
        }
        return nodeArr;
    }


    public static ComNode buildNodeList(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        ComNode next = null;
        ComNode cur = null;
        for (int i=nums.length-1; i>=0; i--) {
            cur = new ComNode(nums[i], next);
            next = cur;
        }
        return cur;
    }
}
