package Dynamic_Programming_Striver;

import java.util.Arrays;

public class _42_longest_increasing_subsequences {
    public static void main(String[] args) {
        int [] arr = {10,34,2,6,30,89,1};
        int length = arr.length;
        System.out.println(lis(arr, 0, -1));

        int [][] dp = new int[length][length+1]; // coordinate shift
        for(int [] a : dp) Arrays.fill(a, -1);
        System.out.println(lis2(arr, 0, -1, dp));

        int [][] Dp = new int[length+1][length+1];
        System.out.println(lis3(arr, Dp));

        System.out.println(lis3(arr));
    }
    // SC : O(n) -- for the recursion stack space
    // TC : O(2^n) -- every element has two options
    public static int lis(int [] arr, int ind, int prev){
        if(ind == arr.length) return 0; // when we don't have any element to take or notTake we simply return 0
        int notTake = lis(arr, ind + 1, prev);
        int take = 0;
        // for the first time the prev will be -1 so to avoid arr[prev] == error we do like this
        if(prev == -1) take = 1 + lis(arr, ind+1, ind);
        // when we found an element that we can add to the subsequence we add 1 to the length
        else if(arr[ind] > arr[prev]) take = 1 + lis(arr, ind+1, ind);
        return Math.max(notTake, take);
    }
    // SC : O(n*n) + O(n)  -- dp array + recursion stack
    // TC : O(n*n) -- for the dp
    public static int lis2(int [] arr, int ind, int prev, int [][] dp){
        if(ind == arr.length) return 0; // when we don't have any element to take or notTake we simply return 0

        if(dp[ind][prev+1] != -1) return dp[ind][prev+1];
        int notTake = lis2(arr, ind + 1, prev, dp);
        int take = 0;
        // for the first time the prev will be -1 so to avoid arr[prev] == error we do like this
//             when we found a element that we can add to the subsequence we add 1 to the length
        if(prev == -1 || arr[ind] > arr[prev]) take = 1 + lis2(arr, ind+1, ind, dp);
        return dp[ind][prev+1] = Math.max(notTake, take);
    }
    public static int lis3(int [] arr, int [][] dp){
        int n = arr.length;
//        for (int i = 0; i <n ; i++){
////            dp[n][i] = 0;
//            dp[i][0] = 1;
//        }

//        for (int i = n-1; i >= 0 ; i--) {
//            for (int j = -1; j < n ; j++) {
//                int notTake = dp[i+1][j+1];
//                int take = 0;
//                if(j == -1 || arr[i] > arr[j]) take = 1 + dp[i+1][i+1];
//                dp[i][j+1] = Math.max(notTake, take);
//            }
//        }
        for (int i = n-1; i >= 0 ; i--) {
            for (int j = i-1; j >= -1; j--) {
                int notTake = dp[i + 1][j+1];
                int take = 0;
                if (j == -1 || arr[i] > arr[j]) take = 1 + dp[i + 1][i+1];
                dp[i][j+1] = Math.max(notTake, take);
            }
        }
            return dp[0][0];
    }
    public static int lis3(int [] arr){
        int n = arr.length;
        int [] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
               if(arr[j] < arr[i]){
                   // it has a bug, because we are updating dp[i] with current elements max, but we forget that we have a max previously, we have to take care of that as well

//                   max = Math.max(dp[i], 1 + dp[j]);
//                   dp[i] = max;

                   // this is the right one
                   dp[i] = Math.max(dp[i], 1 + dp[j]);
                   max = Math.max(dp[i], max);
               }
            }
        }
        return max;
    }
}
