package Leetcode;

import java.util.Stack;

public class _23_MinStack {
    static class MinStack {

        public MinStack() {
        }

        int min = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();

        public void push(int val) {
            if (val <= min) {
                stack.push(min);
                min = val;
            }
            stack.push(val);
        }

        public void pop() {
            if (stack.pop() == min) min = stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

    static class MinStack2 {

        public MinStack2() {
        }

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void push(int val) {
            while (!stack1.isEmpty() && val>stack1.peek()) {
                stack2.push(stack1.pop());
            }
            stack1.push(val);
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        public void pop() {
            stack1.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return stack1.peek();
        }
    }


    public static void main(String[] args) {
        int val = 12;
        MinStack obj = new MinStack();
        obj.push(val);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(param_3);
        System.out.println(param_4);
    }
}
