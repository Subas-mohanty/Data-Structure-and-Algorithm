package Dynamic_Programming_Striver;

import java.util.Arrays;
//https://leetcode.com/problems/house-robber/description/
public class _06_MaxSum_Non_adjacent {
  public static void main(String[] args) {
    int [] arr = {1,4,3,4,5,2,9};
    System.out.println(helper3(arr));
  }
  public int rob(int[] nums) {
    int [] dp = new int[nums.length];
    Arrays.fill(dp, -1);
    return helper(nums.length - 1, nums, dp);
  }
  int helper(int index, int[] arr, int [] dp){
    // if index is 0 that means we have not taken index 1 so, we have to add arr[index] in the answer
    if(index == 0) return arr[0];
    if(index == -1) return 0;

        if(dp[index] != -1) return dp[index];

        // this pick and not pick is the subsequence pattern we learned in recursion
        // do all stuffs on index , either we take the index and take the element behind two index
        int pick = arr[index]+helper(index-2, arr, dp);
        // or we leave/ no pick current index and take its previous index
        int notPick = 0 + helper(index-1, arr, dp);

        return dp[index]=Math.max(pick, notPick);
    }
    // bottom up tabulation approach
    public static int helper2(int index, int [] arr, int [] dp){
      int n = arr.length;
      dp[0]= arr[0];

      // i think we don't need this variable , yeah we don't need it 
      int neg = 0; // we can't store negative index in array so declaring a variable for that

      for (int i = 1; i < n; i++) {
        int pick = arr[i];
        if(i > 1) pick += dp[i - 2]; // if i is 1 or less then the value of dp[i - 2] will be 0 , so no need to add that in the answer
        int notPick = 0 + dp[i - 1]; // if we doesn't pick the current index and pick its previous index then we don't need to add anything in that because it will already take care of the previous ones and dp[i] would have updated correctly
        dp[i] = Math.max(pick, notPick);
      }
      return dp[n - 1];
    }

    public static int helper3(int [] arr){
      int n = arr.length;
      int prev = arr[0];
      int prev2 = 0;
      for (int i = 1; i < n; i++) {
        int pick = arr[i];
        if(i > 1) pick += prev2; // if i is 1 or less then the value of dp[i - 2] will be 0 , so no need to add that in the answer
        int notPick = 0 + prev;
        int ans = Math.max(pick, notPick);
        prev2 = prev;
        prev = ans;
      }
      return prev;
    }
}
