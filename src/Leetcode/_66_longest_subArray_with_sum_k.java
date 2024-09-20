package Leetcode;
//https://shorturl.at/hjyE2

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
}
