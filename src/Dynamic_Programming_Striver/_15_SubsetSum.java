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

    boolean [][] ans = new boolean[n][target+1];
    System.out.println(findSum(arr, n, target, ans));
  }

  // Normal Recursion
  // TC : O(2^n) as every element in the array has 2 option
  // SC : O(n) auxiliary space(extra space) for the recursion stack space
  public static boolean findSum(int [] arr, int index, int target){
    if(target == 0){
      return true;
    }
    if(index == 0 ) return target == arr[index] ;

    boolean pick = false;
    if(arr[index] <= target) pick = findSum(arr, index-1, target - arr[index]);
    boolean notPick = findSum(arr, index - 1, target);

    return pick || notPick;
  }

  // memoization
  // TC : (n*k)
  // SC : O(n) + O(n*k) recursion stack space + the dp array
  public static boolean findSum(int [] arr, int index, int target, int [][] dp){
    // base case
    if(target == 0){
      return true;
    }
    if(index == 0) return target-arr[0] == 0;

    if(dp[index][target] != -1){
//      return dp[index][target] == 0 ? false : true ; // if dp[index][target] == 0 means false value is stored at that index otherwise it is true
      return dp[index][target] != 0;
    }
    boolean pick = false;
    // if the element at the index is greater than the target than there is no use of taking that element into consideration
    if(arr[index] <= target) pick = findSum(arr, index-1, target - arr[index], dp);
    boolean notPick = findSum(arr, index-1, target, dp);

    dp[index][target] = pick || notPick ? 1 : 0 ; // storing 1 for true and 0 for false in the dp array

    return pick || notPick;
  }

  // Tabulation
  // TC : O(n*target)
  // SC : O(n*target) no auxiliary stack space
  public static boolean findSum(int [] arr, int n, int k, boolean [][] dp){
    // for any index if the target is 0 then the ans will be true because we can find the target till that index
    for(int i = 0; i < arr.length; i++){
      dp[i][0] = true;
    }
    // if the first element is smaller than the target than we can make the target using the first element if arr[0] is the target
    if(k >= arr[0]) dp[0][arr[0]] = true;

    // we are taking index i from 1 . why not from 0 ? Because for 0th index only two case will be true i.e, when the target is 0 or the target is same as the first arr[0] element otherwise everytime it will be false and these two cases have been covered in the base case. So we are taking it from 1
    for(int i = 1; i < n; i++){
      for(int target = 1; target <= k; target++){
        boolean notPick = dp[i-1][target]; // if we not take the element then the answer will be same as previous index's target else we have to subtract the element from the target if we pick that element
        boolean pick = false;
        if(arr[i] <= target) pick = dp[i-1][target-arr[i]];
        dp[i][target] = pick || notPick;
      }
    }
    return dp[n-1][k];
  }
}
