package Leetcode.Stack;

import java.util.Stack;
//https://leetcode.com/problems/maximum-width-ramp/?envType=daily-question&envId=2024-10-10

public class _962_max_width_ramp {

    // TC : O(3*n)
    // SC : O(n)

    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        // store elements in the stack in decreasing order, larger element in the bottom
        // then we will check from the end, for every element we will try to find the smallest or equal element in the stack top, if present then update the ans
        for(int i = 0; i < n; i++){
            if(stack.isEmpty() || nums[stack.peek()] > nums[i]) stack.push(i);
        }

        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && nums[i] >= nums[stack.peek()]) ans = Math.max(ans, i - stack.pop());
            if(stack.isEmpty()) break;
        }
        return ans;
    }
}
