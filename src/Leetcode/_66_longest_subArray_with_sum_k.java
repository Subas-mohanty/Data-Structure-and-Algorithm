package Leetcode;
//https://shorturl.at/hjyE2

import java.util.HashMap;
import java.util.Map;

// this is to find the length of the longest subArray with a given sum
public class _66_longest_subArray_with_sum_k {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 1, -1, -1, -1};
        long k = 3;
        System.out.println(longestSubarrayWithSumK(arr, k));
        System.out.println(getLongestSubarray(arr, (int)k));
    }

    // TC : O(2n)
    // SC : O(1)
    // this works only if the array has all positive number and doesn't have 0s
    public static int lenOfLongSubarr(int A[], int N, int K) {
        int n = A.length;

        int i = 0;
        int j = 0;
        int max = 0;

        int sum = 0;
        while(j < n){
            // sum is greater than shrink the window from the left
            while(i < j && sum > K){
                i++;
                sum -= A[i];
            }
            // when sum is equal to K, find the max length
            if(sum == K) max = Math.max(max, j-i+1);
            // otherwise move j and update the sum
            j++;
            if(j < n) sum += A[j];
        }
        return max;
    }


    // TC : O(n^2)
    // SC : O(1)
    public static int longestSubarrayWithSumK(int []a, long k) {
        int ans = 0;
        int i = 0;
        int j = 0;
        int n = a.length;
        while(j < n && i <= j){
            long sum = findSum(a, i, j);
            if(sum == k){
                int length = j-i+1;
                ans = Math.max(ans,length);
            }
            if(sum > k) i++;
            else j++;
        }
        return ans;
    }
    public static long findSum(int [] arr, int s, int e){
        long sum = 0;
        for(int i = s; i <=e ; i++){
           sum+=arr[i];
        }
        return sum;
    }

    // negative numbers included
    // TC : O(n^2)
    // SC : O(1)
    public static int getLongestSubarray(int []a, int k) {
        int ans = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
               sum+=a[j];
               if(sum == k){
                   int length = j-i+1;
                   ans = Math.max(ans, length);
               }
            }
        }
        return ans;
    }



    // for both positive and negative numbers
    // TC : O(n)
    // SC : O(n)
    public static int lenOfLongSubarr2(int A[], int N, int K) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int ans = 0;
        // at each index we are checking if previously curr cumulative sum - K occur or not and if occurs, then at which index

        for(int i = 0; i < N; i++){
            sum += A[i];
            // If the sum is equal to K, update the answer
            if(sum == K) ans = Math.max(ans, i + 1);

            // Check if (sum - K) is already in the map
            if(map.containsKey(sum - K)){
                ans = Math.max(ans, i - map.get(sum - K));
            }

            // Store the prefix sum in the map if it's not already present
            // this check is for negative and 0
            if(!map.containsKey(sum)) map.put(sum, i);
        }
        return ans;
    }
}
