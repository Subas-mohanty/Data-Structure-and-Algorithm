package Dynamic_Programming_Striver;

import java.util.Arrays;

public class _18_countSubsetWithSumK {
    public static void main(String[] args) {
        int [] arr = {1,2,2};
        int n = arr.length;
        int target = 3;
        // if the array contains negative values then we can't store them in the dp array as it will be a negative index in the dp array, instead we can use HashMap
        int [][] dp = new int[n][target+1];
        for(int [] a : dp) Arrays.fill(a,-1);

        System.out.println(findWays(arr, n-1, target));
        System.out.println(findWays2(arr, n-1, target, dp));
        System.out.println(findWays3(arr, target, dp));
    }
    // TC : O(2^n)
    // SC : O(n) --> recursion stack space
    public static int findWays(int [] arr, int index, int tar) {
        if (tar == 0){
            return 1;
        }
        if(index == 0) return tar == arr[0] ? 1 :0 ;

        int notPick = findWays(arr, index-1, tar);
        int pick = 0;
        if(tar >= arr[index]) pick = findWays(arr, index -1, tar-arr[index]);
        return pick + notPick;
    }
    // TC : O(m*n)
    // SC : O(m*n) + O(n) --> for the dp array + recursion stack space
    public static int findWays2(int [] arr, int index, int tar, int [][] dp) {
        if (tar == 0){
            return 1;
        }
        if(index == 0) return tar == arr[0] ? 1 :0 ;

        if(dp[index][tar] != -1) return dp[index][tar];

        int notPick = findWays2(arr, index-1, tar, dp);
        int pick = 0;
        if(tar >= arr[index]) pick = findWays2(arr, index -1, tar-arr[index], dp);
        int ans = pick + notPick;
        dp[index][tar] = ans % 1000000007; // when the ans value goes out of Integer range
        return dp[index][tar];
    }
    // TC : O(m*n)
    // SC : O(m*n) --> for the dp array
    public static int findWays3(int [] arr, int target, int [][] dp){
        int n = arr.length;
        for(int i = 0; i< n; i++){
            dp[i][0] = 1;
        }
        if(target>= arr[0]) dp[0][arr[0]] = arr[0] == target ? 1 : 0;
        for(int i = 1; i<n; i++){
            for (int j = 1; j < target; j++) {
                int notPick = dp[i-1][j];
                int pick = 0;
                if(j >= arr[i]) pick = dp[i-1][target-arr[i]];
                dp[i][j] = notPick + pick;
            }
        }
        return dp[n-1][target];
    }
}
