package com.book.optimize.algorithm.list;

/**
 * Created by yuntao.wu on 2019/9/13.
 */
public class TNode {
    public int val;
    public TNode left;
    public TNode right;

    public TNode(int val) {
        this.val = val;
    }


    public static TNode[] buildTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TNode[] nodes = new TNode[nums.length];
        int i = 0;
        for (int num : nums) {
            nodes[i++] = new TNode(num);
        }
        return nodes;
    }


    public static void printTNode(TNode head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
        System.out.println();
    }

    public  static void printTNode2(TNode head) {
        TNode tail = head;
        while(tail.right != null) {
            tail = tail.right;
        }
        while(tail != null) {
            System.out.print(tail.val + " ");
            tail = tail.left;
        }
        System.out.println();
    }
}
