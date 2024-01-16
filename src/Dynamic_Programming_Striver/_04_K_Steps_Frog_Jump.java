package Dynamic_Programming_Striver;

import java.util.Arrays;

public class _04_K_Steps_Frog_Jump {
    public static void main(String [] args){
        int [] arr = {30, 10, 60, 10, 60, 50};
        int steps = 5;
        int ans = jump(arr.length, arr, steps);
        System.out.println(ans);
    }
    static int jump(int n, int [] arr, int k){
        // return helper(n-1, arr, k);

        int [] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper3(n-1, arr, k, dp);
    }
    static int helper(int index, int [] arr, int k){
        if(index == 0) return 0;

        int minSteps = Integer.MAX_VALUE;

        // for every index it can take k steps so it will go till k for every index
        for(int i = 1; i<=k; i++){
            int cost = Integer.MAX_VALUE;
            if((index-i)>=0){
                cost = helper(index-i, arr, k) + Math.abs(arr[index] - arr[index-i]);
            }
            minSteps = Math.min(minSteps, cost);
        }
        return minSteps;
    }
    // memoization
    // TC: O(N*K)
    // SC : O(N+N) for the dp array and for recursion stack
    static public int helper2(int index, int [] arr, int k, int [] dp){
        if(index == 0) return 0;

        int minSteps = Integer.MAX_VALUE;
        if(dp[index] != -1) return dp[index];
        // for every index it can take k steps so it will go till k for every index
        for(int i = 1; i<=k; i++){
            int cost = Integer.MAX_VALUE;
            if((index-i)>=0){
                cost = helper(index-i, arr, k) + Math.abs(arr[index] - arr[index-i]);
            }
            dp[index] = cost;
            minSteps = Math.min(minSteps, cost);
        }
        return minSteps;
    }
    // tabulation
    // TC: O(N*K)
    // SC : O(N) for the dp array
    static int helper3(int index, int [] arr, int k, int [] dp){
        dp[0] = 0;
        for(int i= 1; i<= index; i++){
            int minSteps = Integer.MAX_VALUE;
            int cost = Integer.MAX_VALUE;

            for(int j=1; j<=k; j++){
                if((i-j)>=0){
                    cost = dp[i-j] + Math.abs(arr[i] - arr[i-j]);
                    minSteps = Math.min(cost, minSteps);
                }
            }
            dp[i] = minSteps;
        }
        return dp[index];
    }
}
