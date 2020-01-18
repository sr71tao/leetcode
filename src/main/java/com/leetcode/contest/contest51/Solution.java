package com.leetcode.contest.contest51;

import java.util.Arrays;

/**
 * Created by yuntao.wu on 2017/9/24.
 */
public class Solution {

    static String STR1 = "7890";
    final static String staticString = "7890";

    public String nextClosestTime(String time) {

        int[] nums = new int[4];
        int[] limit = new int[]{2,4,-1,5,9};
        StringBuilder sb = new StringBuilder(5);

        for (int i =0, j=0; j < time.length(); j++){
            if(j != 2){
                nums[i++] = time.charAt(j) - '0';
            }
        }
        Arrays.sort(nums);
        int i = 0;
        // 从后往前的每一位字符
        for (i = time.length()-1; i >= 0; i--){
            if (i == 2){
                sb.insert(0,":");
                continue;
            }
            int num = time.charAt(i) - '0';
            int j = 0;
            for (; j < 4; j++){
                if (num < nums[j]){     // 找到大于的数字
                    // 判断是否在正常范围内
                    if(i != 1 && nums[j] <= limit[i]){
                        sb.insert(0,nums[j]);
                    }else if (i == 1 && time.charAt(0) == '2' && nums[j] < 4){
                        sb.insert(0,nums[j]);
                    }else if (i == 1 && time.charAt(0) < '2'){
                        sb.insert(0,nums[j]);
                    }else{
                        j = 4;
                    }
                    break;
                }
            }
            if (j != 4){
                sb.insert(0,time.substring(0,i));
                return sb.toString();
            }else{
                sb.append(nums[0]);
            }
        }

        sb.delete(0,sb.length());
        for (int idx = 0; idx < 5; idx++){
            if (idx == 2){
                sb.append(':');
                continue;
            }
            sb.append(nums[0]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.nextClosestTime("13:55"));
//        System.out.println(STR1 == staticString);

//        System.out.println(solution.repeatedStringMatch("ba","ab"));

        TreeNode root = solution.recurseCreate(0, new Integer[]{26, 26, 26, 26, 26, 24, 26, 25, 25, 25, 27, 23,
                                                                25, 25, 27, 24, 26, 24, 26, 24, 24, null, 28, null,
                                                                null, 26, null, null, 26, 26, 28, 25, null, 25, 27, null,
                                                                null, null, null, null, 23, null, null, 29, 27, null, null,
                                                                null, null, 25, null, 27, 27, 24, 26, 24, 26, 26, 26, null,
                                                                22, 28, null, 26, 26, null, null, 26, null, 28, 28, 25, null,
                                                                null, null, 25, 25, 25, 27, 25, 25, 27, 25, null, null, null,
                                                                null, null, null, null, 27, 27, 27, null, null, 27, 29, 24, 26,
                                                                26, 26, null, 26, null, 26, null, null, null, 24, 24, 24, null,
                                                                26, 24, 26, null, null, null, 26, null, null, null, 28, null, 30,
                                                                null, 23, 27, null, null, null, null, null, null, null, null, null,
                                                                null, null, 23, 25, 25, 25, 27, 25, 23, 25, null, null, null, null,
                                                                null, null, 29, null, null, null, 26, null, 22, null, null, 26, 24,
                                                                26, null, 26, 28, null, null, 26, 22, null, null, null, null, null,
                                                                null, null, null, null, null, 25, 23, null, null, null, null, 27});
        System.out.println(solution.longestUnivaluePath(root));
    }

    public int repeatedStringMatch(String A, String B) {
        if(A == null || B == null || A.length() < 1){
            return -1;
        }

        StringBuilder sb = new StringBuilder(A);
        int Alen = A.length();
        int Blen = B.length();
        int count = 1;
        while(Alen * count < Blen){
            count++;
            sb.append(A);
        }
        int totalLen = Alen * count;
        System.out.println(totalLen + " " + count + " " + sb.toString());

        int i = 0;
        for (; i <= totalLen - Blen ;i++){
            if (B.equals(sb.substring(i,i+Blen))){
                return count;
            }
        }
        totalLen+= Alen;
        sb.append(A);
        System.out.println(sb + " " + totalLen);

        for (int j=i; j< Alen; j++){
            System.out.println(B + " "  + sb.substring(j,j+Blen));
            if (B.equals(sb.substring(j,j+Blen))){
                return count+1;
            }
        }
        return -1;
    }


    public int longestUnivaluePath(TreeNode root) {
        if (root == null){
            return 0;
        }
        return recursTree2(root)[2];
    }
    // unused
    int recursTree(TreeNode root, int reVal,int preLen){
        if (root == null){
            return 0;
        }

        int val = root.val;
        if (val == reVal){
            ++preLen;
        }else{
            preLen = 0;
        }
        int lenL = recursTree(root.left, val, preLen);
        int lenR = recursTree(root.right, val, preLen);

        if (root.left != null && root.left.val == val && root.right != null && root.right.val == val){
            lenL = lenL + lenR;
        }
        return Math.max(Math.max(lenL,lenR),preLen);
    }

    // [subVal, subLen, maxLen]
    int[] recursTree2(TreeNode root){
        if (root == null){
            return null;
        }

        int val = root.val;
        int subLen = 0;
        int[] res = new int[]{val,0,0};

        int[] L = recursTree2(root.left);
        int[] R = recursTree2(root.right);

        int lenMaxL = 0;
        int lenMaxR = 0;

        int subLenL = 0;
        int subLenR = 0;
        if (L != null) {
            lenMaxL = L[2];
            if (L[0] == val) {
                subLenL += L[1]+1;
                subLen += L[1];
                subLen += 1;
            }

        }
        if (R != null) {
            lenMaxR = R[2];
            if (R[0] == val) {
                subLenR += R[1]+1;
                subLen += 1;
                subLen += R[1];
            }
        }

        int maxLen = Math.max(Math.max(lenMaxL,lenMaxR),subLen);
        res[1] = Math.max(subLenL,subLenR);
        res[2] = maxLen;

        return res;
    }


    public TreeNode recurseCreate(int nowIdx,Integer[] arr){
        if (nowIdx >= arr.length || arr[nowIdx] == null){
            return null;
        }
        TreeNode node = new TreeNode(arr[nowIdx]);
        node.left = recurseCreate(2*nowIdx+1,arr);
        node.right = recurseCreate(2*nowIdx+2,arr);

        return node;
    }

}

class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
