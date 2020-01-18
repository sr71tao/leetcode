package com.book.optimize.algorithm.tree.page115;

import com.book.optimize.algorithm.tree.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuntao.wu on 2019/9/24.
 * 二叉树找累加和为指定值的最长路径长度
 */
public class Solution {


    public int getMaxLen(Node root, int k) {
        if (root == null) {
            return 0;
        }
        HashMap<Integer, Integer> levelMap = new HashMap<>();
        levelMap.put(0,0);
        Help help = new Help();
        preOrder(root, levelMap, help, k);
        return help.result;
    }

    private void preOrder(Node root, Map<Integer, Integer> sumMap, Help help,int k) {
        if (root == null) {
            return;
        }
        help.sum += root.val;
        ++help.curLevel;
        if (!sumMap.containsKey(help.sum)) {
            sumMap.put(help.sum, help.curLevel);
        }
        if (sumMap.containsKey(help.sum - k)) {
            help.result = Math.max(help.result, help.curLevel - sumMap.get(help.sum-k));
        }
        preOrder(root.left, sumMap, help, k);
        preOrder(root.right,sumMap, help, k);
        if (sumMap.get(help.sum) == help.curLevel) {
            sumMap.remove(help.sum);
        }
        help.sum -= root.val;
        --help.curLevel;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node = Node.buildTree(new Integer[]{-3,3,-9,1,0,2,1,null,null,1,6});
//        Node.preOrder(node);
//        Node.midOrder(node);

        System.out.println(solution.getMaxLen(node, 6));
    }

    protected static class Help {
        int result;
        int sum;
        int curLevel;

    }
}
