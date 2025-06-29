package com.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wuyuntao on 2025/4/26
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }


    public static TreeNode buildTree(Integer[] num) {
        if (num == null || num.length == 0 || num[0] == null) {
            return null;
        }
        List<TreeNode> nodes = Stream.iterate(0, item -> item + 1).limit(num.length)
                .map(e -> {
                    if (num[e] == null) {
                        return null;
                    }
                    return new TreeNode(num[e]);
                }).collect(Collectors.toList());

        Stream.iterate(0, item -> item + 1)
                .limit(nodes.size() - 1)
                .filter(idx -> nodes.get(idx) != null)
                .forEach(idx -> {
                    int lIdx = 2 * idx + 1;
                    int rIdx = 2 * idx + 2;
                    nodes.get(idx).left = lIdx < nodes.size() ? nodes.get(lIdx) : null;
                    nodes.get(idx).right = rIdx < nodes.size() ? nodes.get(rIdx) : null;
                });
        return nodes.get(0);
    }
}
