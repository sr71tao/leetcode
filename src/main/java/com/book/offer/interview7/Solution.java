package com.book.offer.interview7;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Acer on 2020/1/22.
 * 用两个栈实现队列
 */
public class Solution {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        try {
            queue.appendHead(1);
            queue.appendHead(2);
            System.out.println(queue.deleteHead());
            queue.appendHead(0);
            System.out.println(queue.deleteHead());
            System.out.println(queue.deleteHead());
            System.out.println(queue.deleteHead());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Queue<T> {
    Deque<T> stack1 = new LinkedList();
    Deque<T> stack2 = new LinkedList();

    public T deleteHead() throws Exception {
        T t = null;
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                T elem = stack1.pop();
                stack2.push(elem);
            }
        }
        if (stack2.isEmpty()) {
            throw new Exception("queue empty!");
        }
        return stack2.pop();
    }


    public void appendHead(T elem) {
        if (elem ==null) {
            return;
        }
        stack1.push(elem);
    }

}