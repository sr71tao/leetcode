package com.leetcode.contest.contest;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuntao.wu on 2017/8/13.
 */
public class ContextTest {

    RouteCirlcle routeCirlcle;

    @Before
    public void init(){
        routeCirlcle = new RouteCirlcle();
    }


    @Test
    public void judgeCircle(){
        String moves = "DURDLDRRLL";
        System.out.println(routeCirlcle.judgeCircle(moves));
    }


    @Test
    public void findClosestElements(){
        int[] arr = new int[]{0,2,2,3,4,6,7,8,9,9};
        List<Integer> list = new ArrayList<Integer>();
        for (int elem : arr){
            list.add(elem);
        }

        List<Integer> result = routeCirlcle.findClosestElements(list,4,5);
        for (int e : result){
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
