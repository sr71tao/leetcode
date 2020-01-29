package com.book.offer.interview21;

import java.util.LinkedList;

/**
 * Created by Acer on 2020/1/28.
 * 定义一个栈的数据结构,能够以O(1)获取min,push,pop功能
 */
public class Solution {

    public static void main(String[] args) {
        CustomStack<Integer> stack = new CustomStack<>();
        stack.push(3);
        System.out.println(stack.min());

        stack.push(4);
        System.out.println(stack.min());

        stack.push(2);
        System.out.println(stack.min());

        stack.pop();
        System.out.println(stack.min());

        stack.pop();
        System.out.println(stack.min());

        stack.push(1);
        System.out.println(stack.min());
    }
}

class CustomStack<T extends Comparable> {
    private LinkedList<T> stack = new LinkedList<>();
    private LinkedList<T> minStack = new LinkedList<>();

    public T pop() {
        if (stack.isEmpty()) {
            return null;
        }
        minStack.pop();
        return stack.pop();
    }


    public void push(T t) {
        stack.push(t);
        if (minStack.isEmpty()) {
            minStack.push(t);
            return;
        }
        T elem = minStack.peek();
        if (elem.compareTo(t) < 0) {
            minStack.push(elem);
        } else {
            minStack.push(t);
        }
    }

    public T min() {
        if (minStack.isEmpty()) {
            return null;
        }
        return minStack.peek();
    }

}
