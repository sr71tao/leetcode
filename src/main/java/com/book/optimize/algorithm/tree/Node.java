package com.book.optimize.algorithm.tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yuntao.wu on 2019/9/15.
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }


    public static Node buildTree(Integer[] num) {
        if (num == null || num.length == 0 || num[0] == null) {
            return null;
        }
        List<Node> nodes = Stream.iterate(0, item->item+1).limit(num.length).map(e -> {
            if (num[e] == null) {
                return null;
            }
            return new Node(num[e]);
        }).collect(Collectors.toList());

        Stream.iterate(0, item->item+1).limit(nodes.size()-1).filter(idx -> nodes.get(idx) != null).forEach(idx -> {
            int lIdx = 2*idx+1;
            int rIdx = 2*idx+2;
            nodes.get(idx).left = lIdx < nodes.size()? nodes.get(lIdx) : null;
            nodes.get(idx).right = rIdx < nodes.size()? nodes.get(rIdx) : null;
        });
        return nodes.get(0);
    }

    public static Node buildTree(String str) {
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

    private static Node preOrderbuild(Queue<String> queue) {
        String str = queue.poll();
        if (str == null || "#".equals(str)) {
            return null;
        }
        Node node = new Node(Integer.valueOf(str));
        node.left = preOrderbuild(queue);
        node.right = preOrderbuild(queue);
        return node;
    }
    public static Node buildSingleLink(Integer[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        Node next = null;
        Node cur = null;
        for (int i=nums.length-1; i>=0; i--) {
            cur = new Node(nums[i]);
            cur.right = next;
            next = cur;
        }
        return cur;
    }

    public static void printSingleLink(Node root) {
        Node cur = root;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        System.out.println();
    }



    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node last = null;
        while(!stack.isEmpty()) {
            Node node = stack.peek();
            if(node.left != null && last != node.left && last != node.right) {
                stack.push(node.left);
            } else if (node.right != null && last != node.right) {
                stack.push(node.right);
            } else {
                last = stack.pop();
                System.out.print(last.val + " ");
            }
        }
        System.out.println();
    }

    public static void midOrder(Node root) {
        if (root == null) {
            return ;
        }
        Stack<Node> stack = new Stack<>();
        Node head = root;
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



    public static void preOrder(Node root) {
        if (root == null) {
            return ;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node node = stack.pop();
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
