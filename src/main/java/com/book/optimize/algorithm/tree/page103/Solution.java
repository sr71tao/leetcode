package com.book.optimize.algorithm.tree.page103;

import com.book.optimize.algorithm.tree.Node;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yuntao.wu on 2019/9/27.
 * 二叉树的序列化与反序列化
 */
public class Solution {


    public void serialPreOrder(Node node, StringBuilder sb) {
        if (node == null) {
            sb.append("#!");
            return;
        }
        sb.append(node.val).append("!");
        serialPreOrder(node.left, sb);
        serialPreOrder(node.right, sb);
    }

    public Node deserialPreOrder(String str[], int[] idx) {
        if (str == null || str.length <= idx[0] || "#".equals(str[idx[0]])) {
            ++idx[0];
            return null;
        }
        Node node = new Node(Integer.valueOf(str[idx[0]++]));
        node.left = deserialPreOrder(str,idx);
        node.right = deserialPreOrder(str, idx);
        return node;
    }


    public Node deserialPreOrderExample(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] arr = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        return preOrderExample(queue);
    }

    private Node preOrderExample(Queue<String> queue) {
        String str = queue.poll();
        if (str == null || "#".equals(str)) {
            return null;
        }
        Node node = new Node(Integer.valueOf(str));
        node.left = preOrderExample(queue);
        node.right = preOrderExample(queue);
        return node;
    }


    public String serialLevelOrder(Node node) {
        if (node == null) {
            return "#!";
        }
        StringBuilder sb = new StringBuilder();
        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            Node root = queue.poll();
            if (root == null) {
                sb.append("#!");
                continue;
            }
            sb.append(root.val).append("!");
            queue.offer(root.left);
            queue.offer(root.right);
        }
        return sb.toString();
    }

    public Node deserialLevelOrder(String str) {
        if (str == null || "#!".equals(str)) {
            return null;
        }
        String[] arr = str.split("!");
        Node root = new Node(Integer.parseInt(arr[0]));
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < arr.length; i+=2) {
            Node node = queue.poll();
            if (!"#".equals(arr[i])) {
                Node left = new Node(Integer.parseInt(arr[i]));
                queue.offer(left);
                node.left = left;
            }
            if (!"#".equals(arr[i+1])) {
                Node right = new Node(Integer.parseInt(arr[i+1]));
                queue.offer(right);
                node.right = right;
            }
        }
        return root;
    }

    public Node deserialLevelExample(String str) {
        if (str == null || "#!".equals(str)) {
            return null;
        }
        String[] arr = str.split("!");
        int idx = 0;
        Node root = new Node(Integer.parseInt(arr[idx++]));
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            node.left = generateNode(arr[idx++]);
            node.right = generateNode(arr[idx++]);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }


    private Node generateNode(String str) {
        if ("#".equals(str)) {
            return null;
        }
        return new Node(Integer.parseInt(str));
    }




    public static void main(String[] args) {
        Node node = Node.buildTree(new Integer[]{1,2,3,4,null,null,5});
        Solution solution = new Solution();
        /*StringBuilder sb = new StringBuilder();
        solution.serialPreOrder(node,sb);
        System.out.println(sb.toString());*/

       /* Node root = solution.deserialPreOrder(sb.toString().split("!"),new int[1]);
        Node.preOrder(root);
        root = solution.deserialPreOrderExample(sb.toString());
        Node.preOrder(root);*/

       String serial = solution.serialLevelOrder(node);
       System.out.println(serial);
       Node root = solution.deserialLevelExample(serial);
       Node.preOrder(root);
       Node.midOrder(root);



    }
}
