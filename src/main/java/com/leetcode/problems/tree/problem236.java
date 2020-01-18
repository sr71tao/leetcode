package com.leetcode.problems.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuntao.wu on 2019/10/28.
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 */
public class problem236 {


    public TreeNode lowestCommonAncestorExample(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null || root == p || root == q) {
          return root;
      }
      TreeNode leftNode = lowestCommonAncestorExample(root.left, p ,q);
      TreeNode rightNode = lowestCommonAncestorExample(root.right, p, q);
      return leftNode == null? rightNode : rightNode == null? leftNode : root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> leftList = new LinkedList<>();
        List<TreeNode> rightList = new LinkedList<>();
        preOrder(root,p ,leftList);
        preOrder(root,q,rightList);

        TreeNode parent = null;
        for (int i = 0; i < leftList.size() && i < rightList.size(); i++) {
            if (leftList.get(i) == rightList.get(i)) {
                parent = leftList.get(i);
                continue;
            }
            break;
        }
        return parent;
    }


    private boolean preOrder(TreeNode root, TreeNode target, List<TreeNode> list) {
        if (root == null) {
            return false;
        }
        if (root == target) {
            list.add(root);
            return true;
        }
        int size = list.size();
        list.add(root);
        boolean suc = preOrder(root.left, target, list);
        if (suc) {
            return true;
        }
        list = list.subList(0, size+1);
        suc = preOrder(root.right, target, list);
        if (suc) {
            return true;
        }
        list  = list.subList(0, size+1);
        return false;
    }

    private static class TreeNode {
        int val;
        problem236.TreeNode left;
        problem236.TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
