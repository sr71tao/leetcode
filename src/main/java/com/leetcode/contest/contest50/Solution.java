package com.leetcode.contest.contest50;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by yuntao.wu on 2017/9/17.
 */
public class Solution {


    public boolean validPalindrome(String s){
        if (s.length() < 3){
            return true;
        }

        int len = s.length();
        int start =0;
        int end = len-1;
        int startBreak = -1;
        int endBreak = -1;
        boolean had = false;

        while(start < end){
            if (s.charAt(start) == s.charAt(end)){
                ++start;
                --end;
                continue;
            }
            if (had){
                break;
            }
            had = true;
            startBreak = start;
            endBreak = end;
            ++start;
        }
        if (start >= end){
            return true;
        }
        start = startBreak;
        end = endBreak;
        had = false;
        while(start < end){
            if (s.charAt(start) == s.charAt(end)){
                ++start;
                --end;
                continue;
            }
            if (had){
                break;
            }
            had = true;
            --end;
        }
        if (start >= end){
            return true;
        }
        return false;
    }


    public boolean checkValidString(String s) {
        if (s == null){
            return false;
        }
        if(s == ""){
            return true;
        }

        int len = s.length();
        int leftCount = 0;
        int rightCount = 0;
        int starCount = 0;
        char[] chars = s.toCharArray();

       /* StringBuilder sb = new StringBuilder();
        for (char ch : chars){
            if (ch != ')'){
                sb.append(ch);
            }else{
                if (sb.length() > 0 && sb.charAt(sb.length()-1) == '('){
                    sb.deleteCharAt(sb.length()-1);
                }else{
                    sb.append(ch);
                }
            }
        }
        System.out.println(sb);
        chars = sb.toString().toCharArray();*/

        for (char ch : chars){
            if (ch == '('){
                ++leftCount;
            }else if (ch == ')'){
                ++rightCount;
            }else{
                ++starCount;
            }
            if (leftCount + starCount < rightCount){
                return false;
            }
        }
        if (leftCount > starCount + rightCount){
            return false;
        }

       leftCount = 0;
        rightCount = 0;
        starCount = 0;
         for (int i =chars.length-1; i >= 0; i--){
            char ch = chars[i];
            if (ch == '('){
                ++leftCount;
            }else if (ch == ')'){
                ++rightCount;
            }else{
                ++starCount;
            }
            if (leftCount  > rightCount + starCount){
                return false;
            }
        }

        if (rightCount > starCount + leftCount){
            return false;
        }
        return true;
    }




    public static class MapSum {

        HashMap<String,Integer> map = new HashMap();
        LinkedList<String> keys = new LinkedList();
        /** Initialize your data structure here. */
        public MapSum() {

        }

        public void insert(String key, int val) {
            if (map.get(key) == null){
                map.put(key,val);
                keys.add(key);
            }else{
                map.put(key,val);
            }
        }

        public int sum(String prefix) {
            int count = 0;
            if (prefix == null){
                return map.get(prefix);
            }
            for (String key : keys){
                if (key != null && key.startsWith(prefix)){
                    count += map.get(key);
                }
            }
            return count;
        }
    }
}


