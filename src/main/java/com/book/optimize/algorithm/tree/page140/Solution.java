package com.book.optimize.algorithm.tree.page140;

import com.book.optimize.algorithm.tree.Node;

/**
 * Created by yuntao.wu on 2019/9/26.
 * t1 是否包含t2的全部拓扑结构
 */
public class Solution {

    public boolean isContain(Node t1, Node t2) {
        if (t1 == null || t2 == null) {
            return false;
        }

        int maxCount = (int) (Math.pow(2,getHigh(t1))-1);
        Integer[] arr = new Integer[maxCount];
        preOrder(t1, arr, 0);

        /*for (Integer elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();*/

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                continue;
            }
            boolean flag = sameStruct(t2, arr, i);
            if (flag) {
                return true;
            }
        }
        return false;
    }


    private boolean sameStruct(Node root, Integer[] arr, int base) {
        if (root == null) {
            return true;
        }
        if (base > arr.length) {
            return false;
        }
        boolean flag = root.val == arr[base];
        if (!flag) {
            return false;
        }

        boolean lFlag = sameStruct(root.left, arr, 2*base+1);
        if (!lFlag) {
            return lFlag;
        }
        boolean rFlag = sameStruct(root.right, arr, 2*base+2);
        return rFlag;
    }

    // 获取高度
    private int getHigh(Node root) {
        if (root == null) {
            return 0;
        }
        int high = Math.max(getHigh(root.left), getHigh(root.right));
        return high + 1;
    }

    // 生成对应数组
    private void preOrder(Node root,Integer[] arr, int idx) {
        if (root == null) {
            return ;
        }
        arr[idx]= root.val;
        preOrder(root.left, arr, 2*idx+1);
        preOrder(root.right, arr, 2*idx+2);
    }



    public boolean containExmaple(Node t1, Node t2) {
        if (t1 == null) {
            return false;
        }
        return check(t1,t2) || containExmaple(t1.left, t2) || containExmaple(t1.right, t2);
    }


    private boolean check(Node t1,Node t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null || t1.val != t2.val) {
            return false;
        }
        return check(t1.left, t2.left) && check(t1.right, t2.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node t1 = Node.buildTree(new Integer[]{1,2,3,4,5,6,7,8,9,10});
        Node t2 = Node.buildTree(new Integer[]{2,4,5,null,9});
        //System.out.println(solution.isContain(t1, t2));

        System.out.println(solution.containExmaple(t1,t2));
    }
}
