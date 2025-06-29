package com.leetcode.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by wuyuntao on 2025/5/10
 *
 * 仓库管理员以数组 stock 形式记录商品库存表。stock[i] 表示商品 id，可能存在重复。请返回库存表中数量大于 stock.length / 2 的商品 id。
 * 示例 1：
 * 输入：stock = [6, 1, 3, 1, 1, 1]
 * 输出：1
 *
 * 提示：
 * 1 <= stock.length <= 50000
 * 给定数组为非空数组，且存在结果数字
 */
public class ProblemLCR158 {


    public static void main(String[] args) {
        ProblemLCR158 problem = new ProblemLCR158();
        System.out.println(problem.inventoryManagement(new int[]{6, 1, 3, 1, 1, 1}));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        LinkedList<Integer> list = new LinkedList<>();

        HashSet<Integer> set = new HashSet<>();
        set.clear();


    }

    public int inventoryManagement(int[] stock) {
        int count = 0;
        int targetVal = 0;
        for (int j : stock) {
            if (count == 0) {
                targetVal = j;
            }

            if (targetVal == j) {
                ++count;
            } else {
                --count;
            }
        }
        return targetVal;
    }
}
