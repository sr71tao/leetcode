package com.leetcode.contest.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuntao.wu on 2017/8/13.
 */
public class RouteCirlcle {

    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0 ){
            return false;
        }
        if ( (moves.length()&1) == 1){
            return false;
        }

        int upCount = 0;
        int downCount = 0;
        int leftCount = 0;
        int rightCount = 0;

        for (char ch : moves.toCharArray()){
            if (ch == 'L'){
                leftCount++;
            } else if (ch == 'R'){
                rightCount++;
            } else if (ch == 'U'){
                upCount++;
            } else{
                downCount++;
            }

        }
//        System.out.println(leftCount + " " + rightCount + " " + upCount + " " + downCount);
        if (leftCount == rightCount && upCount == downCount && (leftCount != 0 || upCount != 0)){
            return true;
        }

        return false;
    }


    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {

        int low = 0;
        int high = arr.size();
        int mid = -1;
        while(true){
            if (low >= high){
                mid = low;
                break;
            }
            mid = (low + high)/2;
            int value = arr.get(mid);
            if (value == x){
                break;
            } else if (value > x){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }

        int count = 1;
        int big = -1;
        int small = -1;
        if (arr.indexOf(mid) <= x){
           small = mid;
           big = mid+1;
        }else{
            big = mid;
            small = mid-1;
        }

        System.out.println(small + " " + big + " " + count);
        while(count < k && small >= 0 && big < arr.size()){
            if (arr.get(big)-x >= x - arr.get(small)){
                small--;
            }else{
                big++;
            }
            count++;
        }
//        System.out.println(small + " " + big + " " + count);
        while (count < k) {
            if (small < 0) {
                big++;
            } else {
                small--;
            }
            count++;
        }
        System.out.println(small + " " + big + " " + count);

        small = small < 0? 0 : small;
        big = big >= arr.size()? arr.size()-1 : big;
        if (big - small == k){
            if (arr.get(big)-x >= x-arr.get(small)){
                big--;
            }else{
                small++;
            }
        }

        List<Integer> resultList = new ArrayList<Integer>();
        for (int i = small < 0? 0 : small; i<= big && i < small + k; i++){
            resultList.add(arr.get(i));
        }

        return resultList;
    }
}
