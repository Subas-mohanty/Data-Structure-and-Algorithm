package Dynamic_Programming_Striver;
import java.util.Arrays;
//https://leetcode.com/problems/house-robber-ii/description/

public class _07_House_Robber2 {
  public static void main(String[] args) {
    int [] arr= {1,4,7,5,8,6,2,1};
    System.out.println(rob2(arr));
    // the only thing that we need to change in 6th maxSum is here we can't take first and last element together, so first we take the first element and ignore the last and calculate the maxSum then again we ignore the first one and take the last one and calculate the maxSum.
    // Now for the answer we take max of these two
    int [] first = Arrays.copyOfRange(arr, 1, arr.length);
    int [] second = Arrays.copyOfRange(arr, 0, arr.length-1);
    int ans = Math.max(rob(first), rob(second));
    System.out.println(ans);
  }
  public static int rob3(int[] nums) {
    int n = nums.length;
    int ans1 = helper(Arrays.copyOfRange(nums, 1, n), 0);
    int ans2 = helper(Arrays.copyOfRange(nums, 0, n-1), 0);
    return Math.max(ans1, ans2);
    // return helper(nums, 0);
  }
  public static int helper(int [] nums, int ind){
    if(ind == nums.length-1) return nums[ind];
    if(ind >= nums.length) return 0;

    int not = helper(nums, ind+1);
    int take = nums[ind] + helper(nums, ind+2);

    return Math.max(not, take);
  }


  
  public static int rob(int [] arr) {
    int n = arr.length;
    int prev = arr[0];
    int prev2 = 0;
    for (int i = 1; i < n; i++) {
      int pick = arr[i];
      if(i > 1) pick += prev2;
      int notPick = 0 + prev;
      int ans = Math.max(pick, notPick);
      prev2 = prev;
      prev = ans;
    }
    return prev;
  }
  public static int rob2(int [] arr) {
    int n = arr.length;
    int prev = arr[0];
    int prev2 = 0;
    for (int i = 1; i < n - 1; i++) {
      int pick = arr[i];
      if(i > 1) pick += prev2;
      int notPick = 0 + prev;
      int ans = Math.max(pick, notPick);
      prev2 = prev;
      prev = ans;
    }

    int prev3 = arr[1];
    int prev4 = 0;
    for (int i = 2; i < n; i++) {
      int pick = arr[i];
      if(i > 2) pick += prev4;
      int notPick = 0 + prev3;
      int ans = Math.max(pick, notPick);
      prev4 = prev3;
      prev3 = ans;
    }
    return Math.max(prev, prev3);
  }
}
