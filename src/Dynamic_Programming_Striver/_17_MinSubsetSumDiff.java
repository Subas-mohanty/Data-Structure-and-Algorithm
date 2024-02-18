package Dynamic_Programming_Striver;

public class _17_MinSubsetSumDiff {
    public static void main(String[] args) {
        int [] arr = {1,10,3,4};
        int n = arr.length;

        // total sum of the array
        int sum = 0;
        for(int i=0; i<n; i++){
            sum+=arr[i];
        }
        boolean [][] dp = new boolean [n][sum+1];

        System.out.println(sum(arr, n, sum, dp));
    }

    // TC : O(m*n)
    // SC : O(m*n) --> for the dp array
    // this function is same as its previous video function just some add ons

    public static int sum(int [] arr, int n, int sum, boolean [][] dp){
        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }
        if(sum >= arr[0]) dp[0][arr[0]] = true;

        for(int i =1; i<n; i++){
            for(int target = 1; target <= sum; target++){
                boolean notTake = dp[i-1][target];
                boolean take = false;
                if(target >= arr[i]) take = dp[i-1][target-arr[i]];
                dp[i][target] = take || notTake;
            }
        }

        // so the approach to this question is , when we are doing the tabulation solution for any given target, we are calculating for every target value from 0 to target, so here we are taking the target as the total sum of the array
        // now what we will do is , we will check for every target value from 0 to sum(target), and will make sure if the target is possible by taking elements till the end of the array, we will find its subsequent second subset
        // look at the explanation in the _17_.md file

        int min = (int)Math.pow(10,9);
        for(int i=0; i<=sum/2; i++){
            if(dp[n-1][i]){
                int firstSubset = i;
                int secondSubset = sum-firstSubset; // finding the second subset by subtracting totalSum - i(first subset)
                int minSum = Math.abs(secondSubset - firstSubset); // difference between first and second subset
                min = Math.min(min, minSum); // checking for the minimum
            }
        }
        return min;
    }
}
