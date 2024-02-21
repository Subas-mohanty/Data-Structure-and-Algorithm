package Dynamic_Programming_Striver;

import java.util.Arrays;
//https://bit.ly/3r8mG5b

public class _19_count_partitions_with_given_diff {
    public static void main(String[] args) {
        int [] arr = {2,0,8,5,4};
        int n = arr.length;
        int diff = 15;

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
        System.out.println(sum(arr, n-2, target, dp, mod));
    }

    // TC : O(m*n) + O(n) --> for the grid and the array sum
    // SC : O(m*n) + O(n) --> for the dp array and the recursion stack space
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
