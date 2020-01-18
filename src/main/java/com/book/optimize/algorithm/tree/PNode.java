package com.book.optimize.algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yuntao.wu on 2019/10/6.
 */
public class PNode {

    public PNode parent;
    public PNode left;
    public PNode right;
    public int val;

    public PNode(int val) {
        this.val = val;
    }

    public static PNode buildTree(Integer[] num) {
        if (num == null || num.length == 0 || num[0] == null) {
            return null;
        }
        List<PNode> nodes = Stream.iterate(0, item->item+1).limit(num.length).map(e -> {
            if (num[e] == null) {
                return null;
            }
            return new PNode(num[e]);
        }).collect(Collectors.toList());

        Stream.iterate(0, item->item+1).limit(nodes.size()-1).filter(idx -> nodes.get(idx) != null).forEach(idx -> {
            int lIdx = 2*idx+1;
            int rIdx = 2*idx+2;
            nodes.get(idx).left = lIdx < nodes.size()? nodes.get(lIdx) : null;
            nodes.get(idx).right = rIdx < nodes.size()? nodes.get(rIdx) : null;
            if (nodes.get(idx).left != null) nodes.get(idx).left.parent = nodes.get(idx);
            if (nodes.get(idx).right != null) nodes.get(idx).right.parent = nodes.get(idx);
        });
        return nodes.get(0);
    }

    public static PNode buildTree(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] arr = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        return preOrderbuild(queue);
    }

    private static PNode preOrderbuild(Queue<String> queue) {
        String str = queue.poll();
        if (str == null || "#".equals(str)) {
            return null;
        }
        PNode node = new PNode(Integer.valueOf(str));
        node.left = preOrderbuild(queue);
        node.right = preOrderbuild(queue);
        if (node.left != null) node.left.parent = node;
        if (node.right != null) node.right.parent = node;
        return node;
    }

    public static void midOrder(PNode root) {
        if (root == null) {
            return ;
        }
        Stack<PNode> stack = new Stack<>();
        PNode head = root;
        while(!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.val + " ");
                head = head.right;
            }
        }
        System.out.println();
    }



    public static void preOrder(PNode root) {
        if (root == null) {
            return ;
        }
        Stack<PNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            PNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.println();
    }
}
