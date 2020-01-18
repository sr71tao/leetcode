package com.leetcode.contest.contest46;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuntao.wu on 2017/8/20.
 */
public class Image {

    Map<Integer,int[]> map = new HashMap<>();

    public int[][] imageSmoother(int[][] M) {
        if(M == null || M.length  < 1){
            return null;
        }

        int rowLen = M.length;
        int colLen = M[0].length;

        int[][] out = new int[rowLen][colLen];

        // first row
        for (int i =0 ; i< rowLen; i++){
            for (int j = 0 ; j < colLen; j++){
                double sum = 0;
                int num = 0;
                for (int row = i-1; row <= i+1; row++){
                    for (int col = j-1; col <= j+1; col++){
                        if (row < 0 || row >= rowLen || col < 0|| col >= colLen){
                            continue;
                        }
                        sum+= M[row][col];
                        num++;
                    }
                }
                out[i][j] = (int)Math.floor((sum)/num);
            }
        }

        return out;
    }

    // 么搞出来！！
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }

        int max = 1;
        int level = 0;

        return getMaxLen(root,level,max)+1;


    }

    public int getMaxLen(TreeNode root,int level,int max){

        int leftLevel = 0;
        int rightLevel = 1;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        while (leftNode != null && rightNode != null){
            max = Math.max(rightLevel - leftLevel, max);
            level++;
            System.out.println(level +"  l:" + leftLevel + " r:" + rightLevel + "  max:" + max );

            if (leftNode.left != null){
                leftNode = leftNode.left;
                leftLevel = leftLevel * 2;
            }else {
                leftNode = leftNode.right;
                leftLevel = leftLevel*2 + 1;
            }

            if (rightNode.right != null){
                rightNode = rightNode.right;
                rightLevel = rightLevel * 2 + 1;
            }else{
                rightNode = rightNode.left;
                rightLevel = rightLevel * 2;
            }

        }
        if (leftNode != null){
            max = Math.max(max, getMaxLen(leftNode,level,max));
        }
        if (rightNode != null){
            max = Math.max(max, getMaxLen(rightNode,level,max));
        }

      /*  leftLevel = 0;
        rightLevl = 1;
        leftNode = leftNode.left;
        rightNode = leftNode.right;
        if (leftNode != null){

        }

        if (rightNode != null){

        }*/

        return max;
    }



    public int widthOfBinaryTree2(TreeNode root) {

        if (root == null){
            return 0;
        }

        getMaxLen2(root,0,0);
        int max = 1;
        for (int[] arr : map.values()){
            max = Math.max(max,arr[1]-arr[0] +1);
        }

        return max;

    }

    // POS 新节点node在树中的索引号
    public void getMaxLen2(TreeNode node,int level,int pos){
        if (node == null){
            return ;
        }

        int[] solv = map.get(level);
        if (solv == null){
            solv = new int[2];
            solv[0] = Integer.MAX_VALUE;
            solv[1] = Integer.MIN_VALUE;
        }

        solv[0] = Math.min(solv[0],pos);
        solv[1] = Math.max(solv[1],pos);

        map.put(level,solv);

        getMaxLen2(node.left,level+1,pos*2);
        getMaxLen2(node.right,level+1,pos*2+1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
