package com.book.offer.interview18;

import com.book.offer.common.Node;

/**
 * Created by Acer on 2020/1/26.
 * 输入两颗二叉树A,B, 判断B是不是A的子结构
 */
public class Solution {


    private boolean hasSubTree(Node nodeA, Node nodeB) {
        if (nodeA == null || nodeB == null) {
            return false;
        }
        return isSubStruct(nodeA, nodeB);
    }

    private boolean isSubStruct(Node nodeA, Node nodeB) {
        if (nodeB == null) {
            return true;
        } else if (nodeA == null) {
            return false;
        }
        if (nodeA.val == nodeB.val) {
            boolean flag = isSubStruct(nodeA.left, nodeB.left) && isSubStruct(nodeA.right, nodeB.right);
            if (flag) {
                return true;
            }
        }
        return isSubStruct(nodeA.left, nodeB) || isSubStruct(nodeA.right, nodeB);
    }

    private boolean hasSubTree2(Node nodeA, Node nodeB) {
        if (nodeA == null || nodeB == null) {
            return false;
        }
        boolean flag = false;
        if (nodeA.val == nodeB.val) {
            flag = isSubTree(nodeA,nodeB);
        }
        if (flag) {
            return true;
        }
        return hasSubTree2(nodeA.left, nodeB) || hasSubTree2(nodeA.right, nodeB);
    }

    private boolean isSubTree(Node nodeA, Node nodeB) {
        if (nodeB == null) {
            return true;
        } else if (nodeA == null) {
            return false;
        }
        if (nodeA.val != nodeB.val) {
            return false;
        }
        return isSubTree(nodeA.left, nodeB.left) && isSubTree(nodeA.right, nodeB.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node nodeA = Node.buildTree(new Integer[]{8,8,7,9,2,null, null, null,null,4,7});
        Node nodeB = Node.buildTree(new Integer[]{2,null,7,null,null,4});

//        System.out.println(solution.isSubStruct(nodeA, nodeB));
        System.out.println(solution.hasSubTree(nodeA,nodeB));
        System.out.println(solution.hasSubTree2(nodeA,nodeB));

    }
}
