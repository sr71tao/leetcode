package com.leetcode.problems.list;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuntao.wu on 2019/11/3.
 * Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.
 * After doing so, return the head of the final linked list.  You may return any such answer.
 */
public class Problem1171 {

    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return null;
        }

        HashMap<Integer, ListNode> map = new HashMap();
        map.put(0, null);
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count += node.val;
            if (map.containsKey(count)) {
                ListNode pre = map.get(count);
                if (pre == null) {
                    removeKV(map, head, node, count);
                    head = node.next;
                    node = head;
                    continue;
                }
                // remove
                removeKV(map, pre.next, node, count);
                pre.next = node.next;
            } else {
                map.put(count, node);
            }
            node = node.next;
        }

        return head;
    }


    private void removeKV(Map<Integer, ListNode> map, ListNode start, ListNode end, int count) {
        int sum = count;
        while (start != end) {
            sum += start.val;
            map.remove(sum);
            start = start.next;
        }
    }


    public static void main(String[] args) {
        Problem1171 problem = new Problem1171();
        ListNode node = problem.removeZeroSumSublists(buildNode(new int[] {1,0,0,-1,2,-1,0}));
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }


    private static ListNode buildNode(int[] num) {
        ListNode head = new ListNode(num[0]);
        ListNode node = head;
        for (int i =1; i < num.length; i++) {
            node.next = new ListNode(num[i]);
            node = node.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
