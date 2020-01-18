package com.book.optimize.algorithm.list.page74;

import com.book.optimize.algorithm.list.TNode;

import java.util.Stack;

/**
 * Created by yuntao.wu on 2019/9/13.
 * 搜索二叉树构造有序双向链表
 */
public class Solution {

    /**
     * 递归
     * @param root
     * @return
     */
    public TNode buildDoubleLinke2(TNode root) {
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            root.right = root;
            return root;
        }
        TNode leftT = buildDoubleLinke2(root.left);
        TNode leftH = null;
        if (leftT != null) {
            leftH = leftT.right;
            leftT.right = root;
        }
        root.left = leftT;

        TNode rightT = buildDoubleLinke2(root.right);
        TNode rightH = null;
        if (rightT != null) {
            rightH = rightT.right;
            rightH.left = root;
            rightT.right = leftH == null? root : leftH;
        }
        root.right = rightH == null? leftH : rightH;

        return rightT == null? root : rightT;
    }

    /**
     * 栈
     * @param root
     * @return
     */
    public TNode buildDoubleLink(TNode root) {
        if (root == null) {
            return null;
        }

        Stack<TNode> stack = new Stack<>();
        midTravel(root, stack);
        TNode last = stack.pop();
        while(!stack.empty()) {
            TNode node = stack.pop();
            last.left = node;
            node.right = last;
            last = node;
        }
        return last;
    }


    private void midTravel(TNode node, Stack<TNode> stack) {
        if (node == null) {
            return;
        }
        midTravel(node.left, stack);
        stack.push(node);
        midTravel(node.right, stack);
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        TNode[] nodeArr = TNode.buildTree(new int[]{1,2,3,4,5,6,7,8,9});
        nodeArr[5].left = nodeArr[3];
        nodeArr[5].right = nodeArr[6];
        nodeArr[3].left = nodeArr[1];
        nodeArr[3].right = nodeArr[4];
        nodeArr[1].left = nodeArr[0];
        nodeArr[1].right = nodeArr[2];
        nodeArr[6].right = nodeArr[8];
        nodeArr[8].left = nodeArr[7];

        //TNode head = solution.buildDoubleLink(nodeArr[page115]);
        TNode tail = solution.buildDoubleLinke2(nodeArr[5]);
        TNode head = tail.right;
        tail.right = null;
        TNode.printTNode(head);
        TNode.printTNode2(head);
    }

}
