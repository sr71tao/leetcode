package com.leetcode.contest.pratice;

import java.util.Arrays;

/**
 * 493. Reverse Pairs
 * Created by yuntao.wu on 2017/9/2.
 */
public class ReversePairs {

    //  TLE
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }

        int total = 0;
        for (int i = nums.length-1; i > 0; i--){
            for (int j = i-1; j >= 0 ; j--){
                if(nums[j] > 2L*nums[i]){
                    ++total;
                }

            }
        }
        return total;
    }

    public int reversePairs2(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        return mergeSort(nums,0,nums.length-1);

    }


    private int mergeSort(int[] nums,int b, int e){
        if (b >= e){
            return 0;
        }

        int mid = b + (e-b)/2;
        int count = mergeSort(nums,b,mid) + mergeSort(nums,mid+1,e);
        for (int i = b, j = mid+1; i <= mid; i++){
            while(j <= e && nums[i]/2.0 > nums[j] ){
                j++;
            }
            count += j-mid-1;
        }
        Arrays.sort(nums,b,e+1);
        return count;
    }


    public int reversePairs3(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }

        Node root = null;
        int[] count = new int[1];
        for (int i = nums.length-1; i >= 0 ; i--){
            search(root,nums[i]/2.0,count);
            root = buildTree(root,nums[i]);

        }
        return count[0];

    }

    private void search(Node root,double target,int[] count){
        if (root == null){
            return ;
        }

        if (root.val == target){
            count[0] += root.less;
        }else if (root.val > target){
            search(root.left,target,count);
        }else{
            count[0] += root.less + root.same;
            search(root.right,target,count);
        }
    }

    private Node buildTree(Node root, int val){
        if (root == null){
            return new Node(val);
        }
        if (val == root.val){
            root.same++;
        }else if (val > root.val){
            root.right = buildTree(root.right,val);
        }else {
            root.less++;
            root.left = buildTree(root.left,val);
        }
        return root;
    }



    // TLE
    public int reversePairs4(int[] nums) {
        Node root = null;
        int[] cnt = new int[1];
        for(int i = nums.length-1; i>=0; i--){
            search(cnt, root, nums[i]/2.0);//search and count the partially built tree
            root = build(nums[i], root);//add nums[i] to BST
        }
        return cnt[0];
    }

    private void search(int[] cnt, Node node, double target){
        if(node==null) return;
        else if(target == node.val) cnt[0] += node.less;
        else if(target < node.val) search(cnt, node.left, target);
        else{
            cnt[0]+=node.less + node.same;
            search(cnt, node.right, target);
        }
    }

    private Node build(int val, Node n){
        if(n==null) return new Node(val);
        else if(val == n.val) n.same+=1;
        else if(val > n.val) n.right = build(val, n.right);
        else{
            n.less += 1;
            n.left = build(val, n.left);
        }
        return n;
    }



    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        int[] nums = new int[]{5,4,3,2,1};
        System.out.println(reversePairs.reversePairs3(nums));
    }


}

class Node{
    int val ,less = 0, same = 1;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}
