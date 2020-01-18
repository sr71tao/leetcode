package com.book.optimize.algorithm.tree.page153;

import com.book.optimize.algorithm.tree.Node;

import java.util.*;

/**
 * Created by yuntao.wu on 2019/10/7.
 * 查找二叉树两个节点的最近父节点
 */
public class Solution {

    private HashMap<Node,Node> map = new HashMap<>();

    public Node getCommParent(Node root, Node node1, Node node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        List<Node> list1 = new LinkedList<>();
        List<Node> list2 = new LinkedList<>();
        System.out.println(getPreList(root, node1, list1));
        System.out.println(getPreList(root, node2, list2));
        int idx = 0;
        Node node = null;
        while(idx < list1.size() && idx < list2.size()) {
            if (list1.get(idx) == list2.get(idx)) {
                node = list1.get(idx);
            }
            ++idx;
        }
        return node;

    }

    private boolean getPreList(Node root, Node node, List<Node> list) {
       if (root == null) {
           return false;
       }
       list.add(root);
       if (root == node) {
           return true;
       }
       boolean flag = getPreList(root.left, node, list) || getPreList(root.right, node, list);
       if (!flag) {
           list.remove(root);
       }
       return flag;
    }

    public Node getCommParentExample(Node root, Node node1, Node node2) {
        if (root == null || node1 == root || node2 == root) {
            return root;
        }
        Node left = getCommParentExample(root.left, node1, node2);
        Node right = getCommParentExample(root.right, node1, node2);
        if (left != null && right != null) {
            return root;
        }
        return left == null? right : left;
    }

    public Node getCommParentExmaple2(Node node, Node node1, Node node2) {
        if (node == null || node1 == null || node2 == null) {
            return null;
        }
        setMap(node,null);
        Set<Node> set = new HashSet<>();
        while(node1 != null) {
            set.add(node1);
            node1 = map.get(node1);
        }

        while(!set.contains(node2)) {
            node2 = map.get(node2);
        }
        return node2;
    }

    private void setMap(Node node,Node head) {
        if (node == null) {
            return ;
        }
        map.put(node, head);
        if (node.left != null) {
            map.put(node.left, head);
        }
        if (node.right != null) {
            map.put(node.right, head);
        }
        setMap(node.left, node);
        setMap(node.right, node);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node = Node.buildTree("1!2!4!#!#!5!#!#!3!6!#!#!7!8!#!#!#!");
//        Node.preOrder(node);
//        Node.midOrder(node);

//        Node parent = solution.getCommParent(node, node.right.right.left, node.right.left);

        //Node parent = solution.getCommParentExample(node, node.right.right.left, node.right.left);
        Node parent = solution.getCommParentExmaple2(node, node.right.right.left, node.right.left);
        System.out.println(parent == null? null : parent.val);



    }
}
