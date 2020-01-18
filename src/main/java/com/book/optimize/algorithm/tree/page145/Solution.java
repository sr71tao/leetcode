package com.book.optimize.algorithm.tree.page145;

import com.book.optimize.algorithm.tree.Node;

/**
 * Created by yuntao.wu on 2019/10/1.
 * 后续遍历重建二叉树
 */
public class Solution {

    public boolean isBST(int[] arr,int start, int end) {
        if (end <= start) {
            return true;
        }
        int val = arr[end];
        int lend = end - 1;
        for (; lend >= start; lend--) {
            if (val > arr[lend]) {
                break;
            }
        }
        for (int i = lend; i >= start; i--) {
            if (val < arr[i]) {
                return false;
            }
        }
        return isBST(arr,start, lend) && isBST(arr,lend+1, end-1);
    }


    public Node buildWithPost(int[] arr,int start, int end) {
        if (start < 0 || end < 0) {
            return null;
        }
        if (start == end) {
            return new Node(arr[start]);
        }
        int val = arr[end];
        int lend = end - 1;
        for (; val >= start; lend-- ) {
            if (val > arr[lend]) {
                break;
            }
        }
        Node root = new Node(val);
        root.left = buildWithPost(arr,start, lend);
        root.right = buildWithPost(arr, lend+1, end-1);
        return root;
    }




    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{2,7,4,10,14,12,8};
        System.out.println(solution.isBST(arr,0,arr.length-1));

        Node root = solution.buildWithPost(arr, 0, arr.length-1);
        Node.preOrder(root);
        Node.midOrder(root);
    }
}
