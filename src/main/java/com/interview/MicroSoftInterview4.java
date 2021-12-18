package com.interview;

import com.book.offer.common.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树，返回每层的最左节点
 * Created by wuyuntao on 2021/12/16
 */
public class MicroSoftInterview4 {

    public static void main(String[] args) {
        Node root = Node.buildTree(new Integer[]{1, 2, 3, null, 5, 6, 7, null, null, null, 8});
        getLeftNodes(root).forEach(e -> System.out.print(e.val + " "));
        System.out.println();
    }

    private static List<Node> result = new ArrayList<>();

    private static List<Node> getLeftNodes(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Node> result = new ArrayList<>();
        result.add(root);
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        int floorCount = 1;
        int nextFloorCount = 0;
        while (!list.isEmpty()) {
            Node node = list.pollFirst();
            floorCount--;
            if (node.left != null) {
                list.add(node.left);
                nextFloorCount++;
            }
            if (node.right != null) {
                list.add(node.right);
                nextFloorCount++;
            }
            if (floorCount == 0) {
                floorCount = nextFloorCount;
                nextFloorCount = 0;
                Node nextNode = list.peekFirst();
                if (nextNode != null) {
                    result.add(nextNode);
                }
            }
        }
        return result;
    }

    private static void preOrder(Node node, int level) {
        if (node == null) {
            return;
        }
        if (result.size() == level) {
            result.add(node);
        }
        preOrder(node.left, level + 1);
        preOrder(node.right, level + 1);
    }
}
