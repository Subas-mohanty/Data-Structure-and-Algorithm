package Leetcode.Stack;

import java.util.Stack;
//https://leetcode.com/problems/sum-of-subarray-minimums/submissions/1354467438/
//https://www.youtube.com/watch?v=v0e8p9JCgRc

public class _907_sum_of_subArray_min {
    // TC : O(5n) --> next previous and previous smaller takes 2n + 2n + n
    // SC : O(5n) --> array + stack in two functions + n in the main function
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int mod = (int)1e9 + 7;
        int [] nse = findNSE(arr);
        int [] pse = findPSE(arr);
        // the algo is to find the number of element smaller than the current element in the left and right, and then multiplying them to find the number of subsets, then we know that this value will contribute to the answer this amount of time so the total contribution is product * element(arr[i]), now calculate the sum
        for(int i = 0; i < arr.length; i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            long product = (left * right) % mod;
            product = (product * arr[i]) % mod;
            sum = (sum + product) % mod;
        }
        return (int)sum;
    }

    // find next smaller element index if not found then n
    public int [] findNSE(int [] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int [] nse = new int[n];
        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
    }

    // find previous smaller element index, if not found setting it to -1
    public int [] findPSE(int [] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int [] pse = new int[n];
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) stack.pop();
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }
}
