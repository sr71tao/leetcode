package com.interview;

import com.book.offer.common.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.emptyList;

/**
 * 二叉树左侧看到的节点列表
 * Created by yuntao.wu on 2021/12/14.
 */
public class DouyinInterview1 {

    public static void main(String[] args) {
        Node root = Node.buildTree(new Integer[]{1,2,3,null,null,null,7,null,null,null,null, null,null,8});
        getLeftNodes(root).stream().forEach(e -> System.out.print(e.val + " "));
        System.out.println();
    }

    private static List<Node> getLeftNodes(Node node) {
        if (node == null) {
            return emptyList();
        }
        List<Node> result = new ArrayList<>();
        LinkedList<Node> list = new LinkedList<>();
        list.add(node);
        while(!list.isEmpty()) {
            List<Node> nextFloor = new LinkedList<>();
            result.add(list.peekFirst());
            while (list.size() != 0) {
                Node n = list.pollFirst();
                if (n.left != null) {
                    nextFloor.add(n.left);
                }
                if (n.right != null) {
                    nextFloor.add(n.right);
                }
            }
            list.addAll(nextFloor);
        }
        return result;
    }
}
