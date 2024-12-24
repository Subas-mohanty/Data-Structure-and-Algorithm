package Leetcode.Stack;

import java.util.Stack;
import java.util.Arrays;

//https://leetcode.com/problems/asteroid-collision/description/
public class _735_asteroid_collision {
    public static void main(String[] args) {
        int [] arr = {5,10,-5};
        System.out.println(Arrays.toString(asteroidCollision(arr)));
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            // if we find a positive number simply add to the stack
            if (a > 0) stack.push(a);

            // a is negative
            else {
                // until stack.peek() < current element and because current element is negative means remove the top element
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a) stack.pop();

                // if stack is empty or the element in the stack is negative then simply add the current element as it is also negative
                if (stack.isEmpty() || stack.peek() < 0) stack.push(a);

                // if top of stack and current element is same, this means both will explode so remove the element in stack top
                if (stack.peek() == -a) stack.pop();
            }
        }

        // build a array from the stack
        // remember the elements should be in order for ex - the stack top element will be at the last index
        int[] res = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }
        return res;
    }
}
