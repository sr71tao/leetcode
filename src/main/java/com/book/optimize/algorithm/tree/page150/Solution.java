package com.book.optimize.algorithm.tree.page150;

import com.book.optimize.algorithm.tree.Node;

/**
 * Created by yuntao.wu on 2019/10/2.
 * 有序数组生成和平衡二叉树
 */
public class Solution {

    public Node buildBySort(int[] arr, int start,int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new Node(arr[start]);
        }
        int mid = (start+end) >> 1;
        System.out.println(mid);
        Node node = new Node(arr[mid]);
        node.left = buildBySort(arr,start,mid-1);
        node.right = buildBySort(arr,mid+1,end);
        return node;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        Node node = solution.buildBySort(arr, 0,arr.length-1);
        Node.midOrder(node);
    }
}

