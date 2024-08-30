package Leetcode.Stack;

import java.util.Stack;
//https://leetcode.com/problems/largest-rectangle-in-histogram/
public class _84_largest_rectangle_in_histogram {
    public static void main(String[] args) {
        int [] arr = {3,2,5,3,5,4,2,4,3};
        System.out.println(largestRectangleArea(arr));
    }

    // TC : O(n)
    // SC : O(n)
    public static int largestRectangleArea(int[] heights) {
        int [] pse = findPSE(heights); // previous smaller
        int [] nse = findNSE(heights); // next smaller
        int max = 0;

        // for each index find the max rectangle area we can build
        for(int i = 0; i < heights.length; i++){
            int width = nse[i] - pse[i] - 1; // width of the rectangle which we can make at that index
            int area = width * heights[i];
            max = Math.max(area, max);
        }
        return max;
    }

    public static int [] findPSE(int [] arr){
        Stack<Integer> stack = new Stack<>();
        int [] ans = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            if(stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }

    public static int [] findNSE(int [] arr){
        Stack<Integer> stack = new Stack<>();
        int [] ans = new int[arr.length];

        for(int i = arr.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            if(stack.isEmpty()) ans[i] = arr.length;
            else ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
}
