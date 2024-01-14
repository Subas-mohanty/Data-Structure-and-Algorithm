package Dynamic_Programming_Striver;

import java.util.Arrays;
// the question was , you are given an array of numbers and a frog is at the start at each step the frog can take either 1 or 2 step , and while doing that the distance covered by the frog is the absolute difference between the two values which is called the cost. The frog has to reach at the end and you are asked to return the min cost by spending which the frog can reach at the end
public class _03_FrogJump {
    public static void main(String [] args){
        int [] arr = new int[5];
        System.out.println(Arrays.toString(arr));
    }
    public int frogJump(int n, int [] arr){
        // n is the length of the array
        // return helper(n-1, arr);

        int [] dp = new int[n];
        Arrays.fill(dp, -1);
        return dpHelper(n-1, arr, dp);
    }
    public int helper(int index, int [] arr){
        if(index == 0){
            return 0;
        }
        int left = helper(index - 1, arr) + Math.abs(arr[index] - arr[index-1]);
        int right = Integer.MAX_VALUE;
        if(index > 1){
            right = helper(index-2 , arr) + Math.abs(arr[index] - arr[index-2]);
        }
        return Math.min(left, right);
    }

    // dynamic programming memoization method
    public int dpHelper(int index, int [] arr, int [] dp){
        if(index == 0){
            return 0;
        }
        if(dp[index] != -1){
            return -1;
        }
        int left = dpHelper(index-1, arr, dp) + Math.abs(arr[index] - arr[index-1]);
        int right = Integer.MAX_VALUE;
        if(index > 1){
            right = dpHelper(index-2 , arr, dp) + Math.abs(arr[index] - arr[index-2]);
        }
        return dp[index] = Math.min(left, right);
    }

    // tabulation method
    public int jump(int n, int [] arr, int [] dp){
        dp[0] = 0;
        for(int i = 1; i < n; i++){
            int left = dp[i-1] + Math.abs(arr[i] -arr[i-1]);
            int right = Integer.MAX_VALUE;
            if(i>1){
                right = dp[i-2] + Math.abs(arr[i] - arr[i-2]);
            }
            dp[i] = Math.min(left, right);
        }
        return dp[n-1];
    }

    // tabulation method space optimization
    public int jump(int n, int [] arr){
        int prev = 0;
        int prev2 = 0;

        for(int i = 1; i < n; i++){
            int left = prev + Math.abs(arr[i] -arr[i-1]);
            int right = Integer.MAX_VALUE;
            if(i>1){
                right = prev2 + Math.abs(arr[i] - arr[i-2]);
            }
            int current = Math.min(left, right);

            // update the values
            prev2 = prev;
            prev = current;
        }
        return prev;
    }
}
