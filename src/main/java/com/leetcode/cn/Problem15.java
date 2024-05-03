package com.leetcode.cn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by wuyuntao on 2024/5/1
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */
public class Problem15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Set<String> dupSet = new HashSet<>();

        recurTreeSum(nums, 0, new LinkedList<>(), dupSet, result);
        return result;
    }

    // 最大下标
    // 三元组值 & 和
    // 三元组去重
    private boolean recurTreeSum(int[] arr, int maxIdx, List<Integer> sumList, Set<String> dupSet, List<List<Integer>> result) {
        if (sumList.size() == 3) {
            int sum = sumList.stream().mapToInt(t -> t).sum();
            if (sum == 0) {
                String uniqKey = sumList.stream().sorted().map(Object::toString).collect(Collectors.joining("#"));
                if (!dupSet.contains(uniqKey)) {
                    dupSet.add(uniqKey);
                    result.add(new ArrayList<>(sumList));
                }
                return true;
            }
            return false;
        }
        for (int i = maxIdx; i < arr.length; i++) {
            sumList.add(arr[i]);
            boolean flag = recurTreeSum(arr, i+1, sumList, dupSet, result);
            sumList.remove(Integer.valueOf(arr[i]));
            if (flag) {
                break;
            }
        }
        return false;
    }



    public List<List<Integer>> threeSumStand(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums); //
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1;
            int right = nums.length -1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.stream(new int[]{nums[i], nums[left], nums[right]}).boxed().collect(Collectors.toList()));
                    ++left;
                    --right;
                    while(left < right && nums[left] == nums[left-1]) {
                        ++left;
                    }
                    while(left < right && nums[right] == nums[right+1]) {
                        --right;
                    }
                } else if (sum < 0) {
                    ++left;
                } else {
                    --right;
                }

            }

        }
        return result;
    }

    public static void main(String[] args) {
        Problem15 problem15 = new Problem15();
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> finalList = problem15.threeSumStand(arr);
        print(finalList);


        arr = new int[]{0,0,0};
        finalList = problem15.threeSumStand(arr);
        print(finalList);

        arr = new int[]{9,-4,-5,8,-5,7,5,-6,-4,-13,9,-10,-13,-6,2,-15,-13,-9,-4,-13,-9,-9,13,-13,-9,9,-15,1,0,-14,-8,-13,-11,-5,2,0,9,14,9,-9,8,-5,-12,10,-3,5,3,-1,12,14,1,10,12,-1,13,-12,-14,13,4,-7,6,4,-5,11,6,4,-12,0,3,4,-2,-3,7,1,14,-11,-8,2,-5,11,-7,3,6,-9,9,4,-14,10,-6,-2,-11,-14,-13,-9,4,0,11,-1,-15,-9,-12,-1,3,10,7,-5,6,6,12,8,2,-9,-4,-6,-11,-9,5,-10,-14,-15,3};
        finalList = problem15.threeSumStand(arr);
        print(finalList);

    }

    private static void print(List<List<Integer>> finalList) {
        for (List<Integer> list : finalList) {
            list.forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
        System.out.println();
    }
}
