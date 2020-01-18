package com.book.optimize.algorithm.tree.page174;

import java.util.LinkedList;

/**
 * Created by yuntao.wu on 2019/10/10.
 * 前序&中序 构建后序（非构建树）
 */
public class Solution {


    public void buildPostList(int[] preArr, int[] midArr, int lstart, int lend, int rstart, int rend, LinkedList<Integer> queue) {
        if (lend - lstart != rend - rstart) {
            throw new IllegalArgumentException();
        }
        if (lstart > lend || rstart > rend) {
            return;
        }
        if (lend == lstart) {
            queue.push(preArr[lstart]);
            return;
        }
        queue.push(preArr[lstart]);
        int mid = rend;
        while(mid > rstart) {
            if (midArr[mid] == preArr[lstart]) {
                break;
            }
            mid--;
        }
        int lmid = mid-rstart + lstart;
        buildPostList(preArr, midArr, lmid+1, lend, mid+1, rend, queue);
        buildPostList(preArr, midArr, lstart+1, lmid, rstart, mid-1, queue);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preArr = new int[]{1,2,4,5,7,8,3,6,9};
        int[] midArr = new int[]{4,2,7,5,8,1,3,9,6};

        LinkedList<Integer> queue = new LinkedList<>();
        solution.buildPostList(preArr, midArr, 0, preArr.length-1, 0, midArr.length-1, queue);
        queue.forEach(e -> System.out.print(e + " "));
        System.out.println();

    }
}
