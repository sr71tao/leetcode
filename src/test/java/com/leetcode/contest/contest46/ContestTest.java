package com.leetcode.contest.contest46;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuntao.wu on 2017/8/20.
 */
public class ContestTest {

    private Image image = new Image();

    @Test
    public void imageSmoother() {
        int[][] arr = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        int[][] out = image.imageSmoother(arr);
        for (int i=0; i < out.length; i++){
            for (int j = 0; j < out[i].length; j++){
                System.out.print(out[i][j] +" ");
            }
            System.out.println();
        }


    }

    @Test
    public void widthOfBinaryTree(){
        int[] arr = new int[]{1,1,1,1,1,1,1,-1,-1,-1,1,-1,-1,-1,-1,2,2,2,2,2,2,2,-1,2,-1,-1,2,-1,2};
        TreeNode root = new TreeNode(arr[0]);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        for (int i = 1; i < arr.length; i+=2){
            TreeNode node = queue.peek();

            while(node == null && !queue.isEmpty()){
                queue.pop();
                node = queue.peek();
            }
            if (!queue.isEmpty()){
                queue.pop();
            }

            node.left = arr[i] < 0? null : new TreeNode(arr[i]);
            queue.addLast(node.left);

            node.right = (i+1 >= arr.length || arr[i+1] < 0) ? null : new TreeNode(arr[i+1]);
            queue.addLast(node.right);

        }
        System.out.println(image.widthOfBinaryTree2(root));
    }
}
