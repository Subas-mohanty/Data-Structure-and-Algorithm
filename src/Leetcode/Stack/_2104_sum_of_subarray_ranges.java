package Leetcode.Stack;

import java.util.Stack;
//https://leetcode.com/problems/sum-of-subarray-ranges/description/
public class _2104_sum_of_subarray_ranges {

    // brute force
    // TC : O(n^2)
    // SC : O(1)
    public long subArrayRanges2(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum += max - min;
            }
        }
        return sum;
    }

    // optimal approach
    // TC : O(n)
    // SC : O(n)
    // the question is find the sum of diff(max, min) in each subarray, we can easily find that with sum(max) in each subarray - sum(min) in each subarray
    // in leetcode 904 we have already write a function which find the sum(mins) in each subarray, modify it a lil bit to find the sum(maxs)
    // then subtract them to find the answer
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }


    // this will give the sum of all mins in each sub array
    public long sumSubarrayMins(int[] arr) {
        long sum = 0;
        int [] nse = findNSE(arr);
        int [] pse = findPSE(arr);
        for(int i = 0; i < arr.length; i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            long product = left * right;
            product = product * arr[i];
            sum = sum + product;
        }
        return sum;
    }

    // this will give the sum of all max in each sub array
    public long sumSubarrayMaxs(int[] arr) {
        long sum = 0;
        int [] nse = findNGE(arr);
        int [] pse = findPGE(arr);
        for(int i = 0; i < arr.length; i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            long product = left * right;
            product = product * arr[i];
            sum = sum + product;
        }
        return sum;
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

    // find next greater element index, if not found setting it to n
    public int [] findNGE(int [] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int [] nse = new int[n];
        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) stack.pop();
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
    }

    // find previous greater element index, if not found setting it to -1
    public int [] findPGE(int [] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int [] pse = new int[n];
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) stack.pop();
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }
}
