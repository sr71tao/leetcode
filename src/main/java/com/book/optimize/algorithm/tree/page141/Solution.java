package com.book.optimize.algorithm.tree.page141;

import com.book.optimize.algorithm.tree.Node;

/**
 * Created by yuntao.wu on 2019/9/27.
 * t1树是否有t2树拓扑结构完全相同的子数
 */
public class Solution {

    public boolean isSame(Node t1, Node t2) {
        if (t1 == null) {
            return false;
        }
        return check(t1, t2) || isSame(t1.left, t2) || isSame(t1.right, t2);
    }

    private boolean check(Node t1, Node t2) {
        if (t2 == null && t1 == null) {
            return true;
        }
        if (t2 == null || t1 == null) {
            return false;
        }
        return t1.val == t2.val && check(t1.left, t2.left) && check(t1.right, t2.right);
    }


    // TODO
    public boolean isSameExample(Node t1, Node t2) {
        if (t1 == null) {
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Node t1 = Node.buildTree(new Integer[]{1,2,3,4,5,6,7, null, null,9});
        Node t2 = Node.buildTree(new Integer[]{2,4,5,null,8});

        Solution solution = new Solution();
        System.out.println(solution.isSame(t1,t2));
    }
}
