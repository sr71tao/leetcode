package com.book.offer.interview19;

import com.book.offer.common.Node;

/**
 * Created by Acer on 2020/1/27.
 * 二叉树的镜像
 */
public class Solution {

    private void mirrorRecur(Node root) {
        if (root == null) {
            return ;
        }
        Node left = root.left;
        Node right = root.right;
        root.left = right;
        root.right = left;
        mirrorRecur(root.right);
        mirrorRecur(root.left);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        Node root = Node.buildTree(new Integer[]{8,6,10,5,7,9,11});
        Node.preOrder(root);
        Node.midOrder(root);

        solution.mirrorRecur(root);
        Node.preOrder(root);
        Node.midOrder(root);

    }
}
