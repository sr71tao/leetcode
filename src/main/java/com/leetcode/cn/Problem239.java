package com.leetcode.cn;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Created by wuyuntao on 2024/5/11
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 *
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class Problem239 {

    // space:O(n), time:O(nlogn)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        if (k == 1) {
            return nums;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] o1, int[] o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        List<int[]> elemList = IntStream.range(0, nums.length).mapToObj(idx -> new int[]{nums[idx], idx}).collect(toList());
        for (int i = 0; i < nums.length; i++) {
            queue.add(elemList.get(i));
            if (i < k-1) {
                continue;
            }
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            result[i-k+1] = queue.peek()[0];
            // 此操作超时
//            queue.remove(elemList.get(i-k + 1));
        }
        return result;
    }


    public static void main(String[] args) {
        Problem239 problem239 = new Problem239();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = problem239.maxSlidingWindow(nums, 3);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

}
