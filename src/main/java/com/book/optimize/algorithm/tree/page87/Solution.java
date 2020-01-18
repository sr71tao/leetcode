package com.book.optimize.algorithm.tree.page87;

import com.book.optimize.algorithm.tree.Node;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by yuntao.wu on 2019/9/15.
 *
 */
public class Solution {

    public void preOrderRecur(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val +" ");
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }


    public void midOrderRecur(Node root) {
        if (root == null) {
            return;
        }
        midOrderRecur(root.left);
        System.out.print(root.val + " ");
        midOrderRecur(root.right);
    }


    public void postOrderRevur(Node root) {
        if (root == null) {
            return;
        }
        postOrderRevur(root.left);
        postOrderRevur(root.right);
        System.out.print(root.val + " ");
    }


    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            while(node != null) {
                System.out.print(node.val + " ");
                if (node.right != null) {
                    stack.push(node.right);
                }
                node = node.left;
            }
        }
        System.out.println();
    }

    public void midOrder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.val + " ");
            Node right = node.right;
            while(right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        System.out.println();
    }


    public void postOrder(Node root) {
        if (root == null) {
            return ;
        }
        Stack<Node> stack = new Stack<>();
        Node last = null;
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()) {
            Node node = stack.peek();
            if (node.right == last || node.right == null) {
                last = stack.pop();
                System.out.print(last.val + " ");
                continue;
            }
            Node rNode = node.right;
            while (rNode != null) {
                stack.push(rNode);
                rNode = rNode.left;
            }

        }
        System.out.println();
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        Node root = Node.buildTree(new Integer[]{6,4,7,2,5,null,9,1,3,null,null,null,null,8,null});
        /*solution.preOrderRecur(root);
        System.out.println();

        solution.midOrderRecur(root);
        System.out.println();

        solution.postOrderRevur(root);
        System.out.println();*/


//        solution.preOrder(root);

//        solution.midOrder(root);

        solution.postOrder(root);
        Deque stack = new ArrayDeque<>();
        stack = new LinkedList();
    }
}
