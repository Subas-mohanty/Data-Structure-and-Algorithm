package Dynamic_Programming_Striver;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/subset-sum-equal-to-k_1550954?interviewProblemRedirection=true
public class _15_SubsetSum {
  public static void main(String[] args) {
    int [] arr = {1,2,3,4};
    int target = 11;
    int n = arr.length;

    int [][] dp = new int[n][target+1];
    for(int [] temp : dp){
      Arrays.fill(temp, -1);
    }
    System.out.println(findSum(arr, n-1, target, dp));
//    System.out.println(false | false); // we can use bitwise OR instead of logical OR in this case
  }
  // Normal Recursion
  // TC : O(2^n) as every element in the array has 2 option
  // SC : O(n) auxiliary space(extra space) for the recursion stack space
  public static boolean findSum(int [] arr, int index, int target, int [][] dp){
    // base case
    if(target == 0){
      return true;
    }
    if(index == 0) return target-arr[0] == 0;

    if(dp[index][target] != -1){
      return dp[index][target] == 0 ? false : true ; // if dp[index][target] == 0 means false value is stored at that index otherwise it is true
    }

    boolean pick = false;
    // if the element at the index is greater than the target than there is no use of taking that element into consideration
    if(arr[index] <= target) pick = findSum(arr, index-1, target - arr[index], dp);
    boolean notPick = findSum(arr, index-1, target, dp);

    dp[index][target] = pick || notPick ? 1 : 0 ; // storing 1 for true and 0 for false in the dp array

    return pick || notPick;
  }
}
