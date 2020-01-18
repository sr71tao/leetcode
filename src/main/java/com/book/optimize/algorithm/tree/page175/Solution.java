package com.book.optimize.algorithm.tree.page175;

import com.book.optimize.algorithm.tree.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuntao.wu on 2019/10/13.
 * 给定N，求中序序列为{1,2,3,4,5,..,n}的二叉树多少种
 */
public class Solution {

    public int getCount(int n, HashMap<Integer,Integer> map) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int sum = n-1;
        int count = 0;
        for (int i = 0; i <= sum; i++) {
            Integer lcount = getCount(i,map);
            Integer rcount = getCount(sum-i,map);
            count += lcount * rcount;
        }
        map.put(n, count);
        return count;
    }


    public int getCountExample(int n) {
        if (n < 2) {
            return 1;
        }
        int[] num = new int[n+1];
        num[0] = 1;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < i+1; j++) {
                num[i] += num[j-1] * num[i-j];
            }
        }
        return num[n];
    }


    public List<Node> generateTree(int begin, int end) {
        List<Node> list = new LinkedList<>();
        if (begin > end) {
            list.add(null);
        }

        for (int i = begin; i < end + 1; i++) {
            Node head = new Node(i);
            List<Node> lList = generateTree(i-begin, i-1);
            List<Node> rList = generateTree(i+1, end);
            for (Node ln : lList) {
                for (Node rn : rList) {
                    head.left = ln;
                    head.right = rn;
                    list.add(copyTree(head));
                }
            }
        }
        return list;
    }

    private Node copyTree(Node node) {
        if (node == null) {
            return node;
        }
        Node head = new Node(node.val);
        head.left = copyTree(node.left);
        head.right = copyTree(node.right);
        return head;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        HashMap map = new HashMap();
        System.out.println(solution.getCount(5,map));
        System.out.println(solution.getCountExample(5));
    }
}
