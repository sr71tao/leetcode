package com.leetcode.contest.contest49;

import java.util.*;

/**
 * Created by yuntao.wu on 2017/9/10.
 */
public class Solution {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length < 1){
            return 0;
        }

        int total = 1;
        int prev = nums[0];
        int tmp = 1;
        for (int i = 1; i < nums.length; i++){
            if (prev < nums[i]){
                ++tmp;
            }else {
                total = Math.max(total,tmp);
                tmp = 1;
            }
            prev = nums[i];

        }
        total = Math.max(total,tmp);
        return total;
    }





    Map<Integer,Set> map = null;

    /** Initialize your data structure here. */
    public Solution() {

    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        map = new HashMap<>();
        if (dict == null || dict.length == 0) {
            return ;
        }
        for (String value : dict){
            if (!map.containsKey(value.length())){
                HashSet<String> set = new HashSet<>();
                set.add(value);
                map.put(value.length(),set);
            }else{
                Set set = map.get(value.length());
                set.add(value);
            }

        }

    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if (word == null){
            return false;
        }
        if (!map.containsKey(word.length())){
            return false;
        }

        int length = word.length();
        Set<String> set = map.get(word.length());
        Iterator itor = set.iterator();
        while (itor.hasNext()){
            String value = (String) itor.next();
            int difCount = 0;
            for (int i = 0; i < word.length() ; i++){
                if (value.charAt(i) != word.charAt(i)){
                    ++difCount;
                }
                if (difCount > 1 ){
                    break;
                }
            }
            if (difCount != 1){
                continue;
            }
            return true;
        }

        return false;
    }



    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length < 1){
            return 0;
        }



        return 0;
    }

}
