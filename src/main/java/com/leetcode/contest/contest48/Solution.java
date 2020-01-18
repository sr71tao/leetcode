package com.leetcode.contest.contest48;

import java.util.Arrays;

/**
 * Created by yuntao.wu on 2017/9/3.
 */
public class Solution {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null ||( root.left ==null  && root.right == null) ){
            return -1;
        }
        return secondValue(root,root.val);
    }

    private int secondValue(TreeNode node, int pValue){
        if (node == null){
            return -1;
        }
        if (node.val > pValue){
            return node.val;
        }
        int lVal = secondValue(node.left, pValue);
        int rVal = secondValue(node.right,pValue);
        if (lVal == -1){
            return rVal;
        }else if (rVal == -1){
            return lVal;
        }

        return Math.min(lVal,rVal);
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null){
            return null;
        }

        if (root.val < L){   // right sub maybe
            return trimBST(root.right,L,R);
        }

        if (root.val > R){  // left sub maybe
            return trimBST(root.left,L,R);
        }

        root.left = trimBST(root.left,L,R);
        root.right = trimBST(root.right,L,R);

        return root;
    }

    public int maximumSwap(int num) {
        String str = num+"";
        char elem = str.charAt(0);
        int idx = 0;

        int[] values = new int[str.length()];

        for (int i = 0; i < str.length(); i++){
            values[i] = str.charAt(i)-'0';
        }
        Arrays.sort(values);
        /*for (int v : values){
            System.out.print(v + " ");
        }
        System.out.println();*/

        char[] chars = str.toCharArray();
        for (int i=0; i < values.length; i++){
            if (chars[i]-'0' < values[values.length-1-i]){
                // System.out.println(i + " " + (values.length-1-i) + values[values.length-1-i]);
                int pos = values.length-1;
                for (int j = values.length-1; j > i; j--){
                    if (chars[j]-'0' == values[values.length-1-i]){
                        pos = j;
                        break;
                    }
                }
                System.out.println("pos : " + pos);
                char sw = chars[i];
                chars[i] = chars[pos];
                chars[pos] = sw;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : chars){
            sb.append(ch);
        }
        return Integer.parseInt(sb.toString());
    }
}

class TreeNode{
    int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
}
