package com.book.offer.interview25;

import com.book.optimize.algorithm.tree.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Acer on 2020/1/29.
  二叉树中和为某一值的所有路径
 */
public class Solution {


    private void getPathByValue(Node root, int val, List<List<Integer>> result) {
        if (root == null) {
            return ;
        }
        pathRecur(root, val, 0, new LinkedList<>(), result);
    }

    private void pathRecur(Node node, int val, int tmpVal,List<Node> nodeList, List<List<Integer>> result) {
        nodeList.add(node);
        if (node.left == null && node.right == null) {
            if (val == tmpVal + node.val) {
                result.add(copy(nodeList));
            }
            nodeList.remove(node);
            return;
        }
        if (node.left != null) {
            pathRecur(node.left, val, tmpVal + node.val, nodeList, result);
        }
        if (node.right != null) {
            pathRecur(node.right,val, tmpVal + node.val, nodeList, result);
        }
        nodeList.remove(node);
    }

    private List<Integer> copy(List<Node> nodeList) {
        if (nodeList == null || nodeList.isEmpty()) {
            return null;
        }
        List<Integer> list = new LinkedList<>();
        nodeList.forEach(e -> {
            list.add(e.val);
        });
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node root = Node.buildTree(new Integer[]{10,5,12,4,7});
        List<List<Integer>> result = new LinkedList<>();
        solution.getPathByValue(root, 19, result);
        result.forEach(li -> {
            li.forEach(e -> System.out.print(e + " "));
            System.out.println();
        });
        System.out.println();
    }
}
