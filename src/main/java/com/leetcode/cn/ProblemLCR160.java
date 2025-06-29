package com.leetcode.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by wuyuntao on 2025/5/29
 */
public class ProblemLCR160 {

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        int[] arr = new int[]{6,10,2,6,5,0,6,3,1,0,0};
        for (int num : arr) {
            finder.addNum(num);
            System.out.println(finder.findMedian());
        }

    }

}

// standar
class MedianFinder {

    Queue<Integer> A;
    Queue<Integer> B;
    /** initialize your data structure here. */
    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆
        B = new PriorityQueue<>((x, y) -> y-x); // 大顶堆
    }

    public void addNum(int num) {
        if (A.size() == B.size()) {
            B.add(num);
            A.add(B.poll());
            return;
        }
        A.add(num);
        B.add(A.poll());
    }

    public double findMedian() {
        if (A.isEmpty()) {
            return 0;
        }
        if (B.isEmpty()) {
            return A.peek();
        }
        if (A.size() == B.size()) {
            return ((double)A.peek() + (double) B.peek())/2;
        }
        return A.peek();
    }
}
class MedianFinder2 {

    /** initialize your data structure here. */
    ArrayList<Integer> list;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    public MedianFinder2() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {

        if (num <= min) {
            list.add(0, num);
            min = Math.min(num, min);
            max = Math.max(num, max);
            return;
        } else if ( num >= max) {
            list.add(num);
            min = Math.min(num, min);
            max = Math.max(num, max);
            return;
        }

        int start = 0;
        int end = list.size();

        while (start <= end) {
            int mid = (end + start)/2;
            if (list.get(mid) == num) {
                start = mid;
                break;
            } else if (list.get(mid) > num) {
                end = mid -1;
            } else {
                start = mid+1;
            }
        }
        list.add(start, num);


    }

    public double findMedian() {
        if (list.isEmpty()) {
            return 0;
        }
        if (list.size() % 2 == 1) {
            return list.get(list.size()/2);
        }
        return ((double)list.get(list.size()/2-1) + list.get(list.size()/2)) / 2;

    }
}
