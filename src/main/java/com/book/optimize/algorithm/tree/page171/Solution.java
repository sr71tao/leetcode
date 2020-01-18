package com.book.optimize.algorithm.tree.page171;

import com.book.optimize.algorithm.tree.Node;

/**
 * Created by yuntao.wu on 2019/10/9.
 * 前中后序构造二叉树
 */
public class Solution {

    public Node buildPreOrder(int[] preArr,int[] midArr) {
        if (preArr == null || midArr == null || preArr.length != midArr.length) {
            return null;
        }
        return buildPreTree(preArr, midArr, 0 , preArr.length-1, 0, midArr.length-1);
    }

    private Node buildPreTree(int[] preArr, int[] midArr, int lstart, int lend, int rstart, int rend) {
        if (lend - lstart != rend - rstart) {
            throw new IllegalArgumentException();
        }
        if (lstart > lend || rstart > rend) {
            return null;
        }
        if (lstart == lend) {
            return new Node(preArr[lstart]);
        }
        Node node = new Node(preArr[lstart]);
        int rmid = rend;
        while( rmid > rstart) {
            if (preArr[lstart] == midArr[rmid]) {
                break;
            }
            rmid--;
        }
        int lmid = rmid - rstart + lstart;
        node.left = buildPreTree(preArr, midArr, lstart+1, lmid, rstart, rmid-1);
        node.right = buildPreTree(preArr, midArr, lmid+1,lend, rmid+1, rend);
        return node;
    }


    public Node buildPostOrder(int[] postArr,int[] midArr) {
        if (postArr == null || midArr == null || postArr.length != midArr.length) {
            return null;
        }
        return buildPostTree(postArr, midArr, 0 , postArr.length-1, 0, midArr.length-1);
    }

    private Node buildPostTree(int[] postArr, int[] midArr, int lstart, int lend, int rstart, int rend) {
        if (lend - lstart != rend - rstart) {
            throw new IllegalArgumentException();
        }
        if (lstart > lend || rstart > rend) {
            return null;
        }
        if (lstart == lend) {
            return new Node(postArr[lstart]);
        }
        Node node = new Node(postArr[lend]);
        int rmid = rend;
        while( rmid > rstart) {
            if (postArr[lend] == midArr[rmid]) {
                break;
            }
            rmid--;
        }
        int lmid = rmid - rstart + lstart;
        node.left = buildPostTree(postArr, midArr, lstart, lmid-1, rstart, rmid-1);
        node.right = buildPostTree(postArr, midArr, lmid,lend-1, rmid+1, rend);
        return node;
    }


    public Node buildNonMidOrder(int[] preArr, int[] postArr) {
        if (preArr == null || postArr == null | preArr.length != postArr.length) {
            return null;
        }
        return buildNonMidTree(preArr, postArr, 0, preArr.length-1, 0, postArr.length-1);
    }

    public Node buildNonMidTree(int[] preArr, int[] postArr, int lstart, int lend, int rstart, int rend) {
        if (lend - lstart != rend - rstart) {
            System.out.println(lstart + " " + lend + " " + rstart + " " + rend);
            throw new IllegalArgumentException();
        }
        if (lstart > lend || rstart > rend) {
            return null;
        }
        if (lstart == lend || rstart == rend) {
            return new Node(preArr[lstart]);
        }

        Node node = new Node(preArr[lstart]);
        int rmid = rend-1;
        while(rmid > rstart) {
            if (postArr[rmid] == preArr[lstart+1]) {
                break;
            }
            rmid--;
        }
        int lmid = lstart + rmid - rstart + 1;
        node.left = buildNonMidTree(preArr, postArr, lstart+1, lmid, rstart, rmid);
        node.right = buildNonMidTree(preArr, postArr, lmid+1, lend, rmid+1, rend-1);
        return node;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        /*int[] preArr = new int[]{1,2,4,5,7,8,3,6,9};
        int[] midArr = new int[]{4,2,7,5,8,1,3,9,6};*/
        int[] midArr = new int[]{4,2,8,5,9,1,6,3,7};
        int[] preArr = new int[]{1,2,4,5,8,9,3,6,7};
        int[] postArr = new int[]{4,8,9,5,2,6,7,3,1};

//        Node node = solution.buildPreOrder(preArr, midArr);
//        Node node = solution.buildPostOrder(postArr, midArr);
        Node node = solution.buildNonMidOrder(preArr, postArr);
        Node.midOrder(node);
        Node.preOrder(node);
        Node.postOrder(node);
    }

}
