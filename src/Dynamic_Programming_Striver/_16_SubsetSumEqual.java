package Dynamic_Programming_Striver;

import java.util.Arrays;
//https://bit.ly/34iIIsH

public class _16_SubsetSumEqual {
  public static void main(String[] args) {
    int [] arr = {1,2,23,4};

    // finding the sum of all the elements of the array
    int sum = 0;
    for (int num : arr) {
      sum+= num;
    }
    // The question states that whether the array can be divided into two subsets whose sum will be equal, that means the two subsets will have sum equal to total sum of the array divided by 2, so if the sum is odd then the ans will be false as we can't divide it into two parts else the target will be sum/2, and it can be solved by the previous approach used in _15_SubsetSum.java
    int target = sum/2;
    int n = arr.length;

    int [][] dp = new int[n][target+1];
    for(int [] temp : dp){
      Arrays.fill(temp, -1);
    }
    if((sum & 1) == 1){
      System.out.println(false);
    }
    else {
      System.out.println(findSum(arr, n-1, target, dp));
    }
//    (sum & 1) == 1 ? return false : return findSum(arr, n -1 , target, dp); we can't do like this , because returning a function using a ternary operator is not allowed in java
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
