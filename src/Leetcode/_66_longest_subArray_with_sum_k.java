package Leetcode;

public class _66_longest_subArray_with_sum_k {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 1, -1, -1, -1};
        long k = 3;
        System.out.println(longestSubarrayWithSumK(arr, k));
        System.out.println(getLongestSubarray(arr, (int)k));
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
