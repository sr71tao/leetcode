package com.leetcode.cn;

import java.util.LinkedList;

/**
 * Created by wuyuntao on 2024/5/20
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类
 */
public class Problem155 {
    class MinStack {
        private final LinkedList<Integer> stack = new LinkedList<>();
        private final LinkedList<Integer> minStack = new LinkedList<>();

        public MinStack() {
        }


        public void push(int val) {
            System.out.println("push " + val);
            stack.push(val);
            if (minStack.isEmpty()) {
                minStack.push(val);
                return;
            }
            int minVal = minStack.peek();
            if (minVal >= val) {
                minStack.push(val);
            }
        }


        public void pop() {
            if (stack.isEmpty()) {
                return;
            }
            int val = stack.pop();
            System.out.println("pop " + val);
            if (val == minStack.peek()) {
                minStack.pop();
            }
        }


        public int top() {
            return stack.peek();
        }


        public int getMin() {
            if (minStack.isEmpty()) {
                return -1;
            }
            return minStack.peek();
        }
    }


    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */


    public static void main(String[] args) {
        Problem155 problem155 = new Problem155();
        MinStack stack = problem155.buildMinStack();
        stack.push(5);
        System.out.println("top:" + stack.top() + " min:" + stack.getMin());
        stack.push(6);
        System.out.println("top:" + stack.top() + " min:" + stack.getMin());
        stack.push(3);
        System.out.println("top:" + stack.top() + " min:" + stack.getMin());
        stack.push(4);
        System.out.println("top:" + stack.top() + " min:" + stack.getMin());
        stack.pop();
        System.out.println("top:" + stack.top() + " min:" + stack.getMin());
        stack.pop();
        System.out.println("top:" + stack.top() + " min:" + stack.getMin());
        stack.push(10);
        System.out.println("top:" + stack.top() + " min:" + stack.getMin());
        stack.push(8);
        System.out.println("top:" + stack.top() + " min:" + stack.getMin());
        stack.push(8);
        System.out.println("top:" + stack.top() + " min:" + stack.getMin());
        stack.pop();
        System.out.println("top:" + stack.top() + " min:" + stack.getMin());
        stack.pop();
        System.out.println("top:" + stack.top() + " min:" + stack.getMin());
        stack.pop();
        System.out.println("top:" + stack.top() + " min:" + stack.getMin());
        stack.pop();
        System.out.println("top:" + stack.top() + " min:" + stack.getMin());
    }


    private MinStack buildMinStack() {
        return new MinStack();
    }
}
