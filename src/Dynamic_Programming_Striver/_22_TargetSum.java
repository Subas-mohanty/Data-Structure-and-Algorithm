package Dynamic_Programming_Striver;
//https://bit.ly/3swy5uL
// this is totally same as _19_count problem
// let's understand the question , it says we are given an array , change the sign of it's element to find a target, the number of ways to form the target
// when we change the sign of the elements some elements will be positive and some will be negative , if we take the difference it will be the target that is given to us, so we can easily apply the count partitions with given difference problem's solution
import java.util.Arrays;

public class _22_TargetSum {
  public static void main(String[] args) {
      int [] arr = {1,1,1,1};
      int n = arr.length;
      int diff = 0;

      // total sum of the array
      int sum = 0;
      for(int i=0; i<n; i++){
          sum+=arr[i];
      }
      // sum function
      // s1-s2 = d and s1+s2 = sum
      // => s1 = sum - s2
      // => sum - s2 - s2 = d ( as s1-s2 = d )
      // => sum - d = 2*s2
      // => s2 = (sum - d)/2
      // this will be our new target so if we found this target, this means there is a subset s1 is present where s1 - s2 = d

      int target = (sum - diff)/2;
      int mod = (int)Math.pow(10,7)+7; // this is for the constraint that if the ans should not go beyond this limit

      // the array does not contain negative elements so if sum - diff goes to negative than there is wrong input so return 0 or no path found
      // if sum - diff is odd then the target will go to decimal so no target will be found and the answer will be 0
      if(sum - diff < 0 || (sum-diff) % 2 == 1){
          System.out.println(0);
          return;
      }
      int [][] dp = new int[n][target+1];
      for(int [] a : dp) Arrays.fill(a,-1);
      System.out.println(sum(arr, n-1, target, dp, mod));
  }
    public static int sum(int [] arr ,int index, int target, int [][] dp, int mod){
        // if the constraint is elements in the array is >=1
//        if(target == 0) return 1;
//        if(index == 0) return target == arr[0] ? 1 : 0 ;

        // if the constraint is elements in the array is >=0
        if (index == 0) {
            if(target == 0 && arr[0] == 0) return 2; // either we can take the first 0 or not both will give us the target
            if(target == 0 || arr[0] == target) return 1; // target is 0 so if the value is different from 0 then there is 1 subset by not taking it, or if the first element = target then also we have one subset by taking the value
            return 0;
        }
        if(dp[index][target] != -1) return dp[index][target];

        int notPick = sum(arr, index-1, target, dp, mod);
        int pick = 0;
        if(target >= arr[index]) pick = sum(arr, index-1, target-arr[index], dp, mod);

        return dp[index][target] = (pick+notPick) % mod;
    }
}
