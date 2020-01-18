package com.leetcode.contest.pratice;

import java.util.*;

/**
 * Created by yuntao.wu on 2017/10/15.
 */
public class Solution {

    HashMap<String,Integer> map = new HashMap(200);
    StringBuilder sb = new StringBuilder();
    int count;

    Set<Integer> set = new HashSet<>();

    private void allRange(String str){
        if (str == null){
            return ;
        }

        // 字母
//        recursive(str.toCharArray(),0,str.length());

        int[] numbers = new int[str.length()];
        for (int i = 0; i < str.length(); i++){
            numbers[i] = str.charAt(i) - '0';
        }
        Arrays.sort(numbers);

        // 数字
//        recursive(numbers,new LinkedList<Integer>(),new boolean[str.length()]);

        permuteUnique(numbers,0);
    }


    private void recursive(char[] arr,int start, int end){
        if (start == arr.length-1){
            for (char ch : arr){
                System.out.print(ch);
            }
            System.out.println();
            return;
        }

        for (int i = start;i < arr.length; i++){
            if (isSwap(arr,start,i)){
                swap(arr,start,i);
                recursive(arr,start+1,arr.length);
                swap(arr,start,i);
            }
        }
    }


    private boolean isSwap(char[] arr,int start,int end){
        for (;start < end;start++){
            if (arr[start] == arr[end]){
                return false;
            }
        }

        return true;
    }

    private void recursive(int[] arr, List<Integer> list, boolean[] used){
        if (list.size() == arr.length){
            for (int ch : list){
                System.out.print(ch + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++){
            if (used[i]){
                continue;
            }

            if (i > 0 && arr[i] == arr[i-1] && !used[i-1]){
                continue;
            }
            used[i] = true;
            list.add(arr[i]);
            recursive(arr,list,used);
            list.remove(list.size()-1);
            used[i] = false;

        }
    }

    private void permuteUnique(int[] arr,int start){
        if (start == arr.length-1){
            for (int ch : arr){
//                System.out.print(ch + " ");
                sb.append(ch).append(" ");
            }
//            System.out.println();
            if (map.containsKey(sb.toString())){
                System.out.println(map.get(sb.toString()) + " " + (count+1) + " " + sb.toString() );
            }
            map.put(sb.toString(),++count);
            sb.delete(0,sb.length());
            return;
        }

        for (int i = start; i < arr.length; i++){
            if (i > start && set.contains(arr[i])){
                continue;
            }
            set.add(arr[i]);
            swap(arr,start,i);

            permuteUnique(arr,start+1);

            swap(arr,start,i);
            set.remove(arr[i]);
        }
    }


    private void swap(char[] arr, int before, int after){
        char ch = arr[before];
        arr[before] = arr[after];
        arr[after] = ch;
    }

    private void swap(int[] arr, int before, int after){
        int ch = arr[before];
        arr[before] = arr[after];
        arr[after] = ch;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.allRange("1122");
        int[] arr = new int[]{-1,2,0,-1,1,1};
        Arrays.sort(arr);

        solution.permuteUnique(arr,0);
        System.out.println(solution.count);
//        solution.recursive(arr,new ArrayList<Integer>(), new boolean[arr.length] );
    }
}
