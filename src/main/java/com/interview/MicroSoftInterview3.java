package com.interview;

import com.book.offer.common.Node;

/**
 * 二叉搜索树删除指定节点
 * Created by wuyuntao on 2021/12/15
 */
public class MicroSoftInterview3 {

    public static void main(String[] args) {
        Node root = Node.buildTree(new Integer[]{6, 4, 8, 3, null, null, 9});
        root = removeNode(root, 4);
        Node.preOrder(root);
        Node.midOrder(root);
    }

    private static Node parentNode;
    // 二叉搜索树
    private static Node removeNode(Node root, int targetVal) {
        if (root == null) {
            return null;
        }
        Node removeNode = findNode(null, root, targetVal);
        if (removeNode == null) {
            return root;
        }
        if (root == removeNode && root.left == null && root.right == null) {
            return null;
        }
        // 右子树为空
        Node replaceNode = null;
        if (removeNode.right == null) {
            replaceNode = pollLastMidOrder(removeNode, removeNode.left);
        } else {
            replaceNode = pollFirstMidOrder(removeNode, removeNode.right);
        }
        if (replaceNode != null) {
            if (removeNode.right == null) {
                replaceNode.left = removeNode.left;
            } else {
                replaceNode.left = removeNode.left;
                replaceNode.right = removeNode.right;
            }
        }
        if (removeNode == root) {
            return replaceNode;
        }
        if (parentNode.left == removeNode) {
            parentNode.left = replaceNode;
        } else {
            parentNode.right = replaceNode;
        }
        return root;
    }

    // 取中序遍历第一个节点
    private static Node pollFirstMidOrder(Node removeParentNode, Node node) {
        if (node == null) {
            return null;
        }
        Node prev = removeParentNode;
        Node cur = node;
        Node nxt = node.left;
        while (nxt != null) {
            prev = cur;
            cur = nxt;
            nxt = nxt.left;
        }
        if (prev == removeParentNode) {
            prev.right = cur.right;
            cur.right = null;
        } else {
            prev.left = cur.right;
            cur.right = null;
        }
        return cur;
    }

    // 取中序遍历最后一个节点
    private static Node pollLastMidOrder(Node removeParentNode, Node node) {
        if (node == null) {
            return null;
        }
        Node prev = removeParentNode;
        Node cur = node;
        Node nxt = cur.right;
        while (nxt != null) {
            prev = cur;
            cur = nxt;
            nxt = nxt.right;
        }
        if (prev == removeParentNode) {
            prev.left = cur.left;
            cur.left = null;
        } else {
            prev.right = cur.left;
            cur.left = null;
        }
        return cur;
    }

    private static Node findNode(Node parent, Node root, int targetVal) {
        if (root == null) {
            return null;
        }
        if (root.val == targetVal) {
            parentNode = parent;
            return root;
        }
        if (root.val < targetVal) {
            return findNode(root, root.right, targetVal);
        }
        return findNode(root, root.left, targetVal);
    }

}
