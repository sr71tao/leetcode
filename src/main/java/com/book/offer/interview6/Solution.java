package com.book.offer.interview6;

import com.book.offer.common.Node;

/**
 * 前中序构建二叉树
 */
public class Solution {

    private Node buildTree(int[] preOrder, int[] midOrder) throws Exception {
        if (preOrder == null || midOrder == null || preOrder.length < 1 || midOrder.length < 1 || preOrder.length != midOrder.length){
            return null;
        }
        Node node = buildTree(preOrder, 0, preOrder.length - 1, midOrder, 0, midOrder.length - 1);
        return node;
    }

    private Node buildTree(int[] preOrder, int pstart, int pend, int[] midOrder, int mstart, int mend) throws Exception {
        if (pstart > pend || mstart > mend) {
            return null;
        }
        if (pstart == pend && mstart == mend) {
            if (preOrder[pstart] != midOrder[mstart]) {
                throw new Exception("not find elem in midOrder val:" + preOrder[pstart]);
            }
            return new Node(preOrder[pstart]);
        }
        Node root = new Node(preOrder[pstart]);
        int idx = -1;
        for (int i = mstart; i <= mend; i++) {
            if (preOrder[pstart] == midOrder[i]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            throw new Exception("not find elem in midOrder val:" + root.val);
        }
        int lsize = idx - mstart;
        root.left = buildTree(preOrder, pstart+1, pstart + lsize, midOrder, mstart, idx-1);
        root.right = buildTree(preOrder, pstart+lsize+1, pend, midOrder, idx+1, mend);
        return root;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] preOrder = new int[]{1,2,4,7,3,5,6,8};
//        int[] midOrder = new int[]{4,7,2,1,5,3,8,6};

        int[] preOrder = new int[]{1,2,4,5};
        int[] midOrder = new  int[]{4,5,2,1};
        Node node = null;
        try {
            node = solution.buildTree(preOrder, midOrder);
            Node.preOrder(node);
            Node.midOrder(node);
            Node.postOrder(node);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
