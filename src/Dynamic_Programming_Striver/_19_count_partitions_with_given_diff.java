package Dynamic_Programming_Striver;

import java.util.Arrays;
//https://bit.ly/3r8mG5b

public class _19_count_partitions_with_given_diff {
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

        int [][] Dp = new int[n][target+1];
        System.out.println(sum2(arr, target, Dp, mod));
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
    // Tabulation
    // TC : O(m*n)
    // SC : O(m*n) --> for the dp array
    public static int sum2(int [] arr, int target, int [][] dp, int mod){
        int n = arr.length;
        if(arr[0] == 0 ) dp[0][0] = 2;
        else dp[0][0] = 1;

//        if(arr[0] != 0 && target>= arr[0]) dp[0][arr[0]] = arr[0] == target ? 1 : 0; // we can't do it here because in this case no matter what the arr[0] is we will add 1 for that target in the dp array, because its not tabulation, in recursion we can do like that so when that function call arrives the statement will be true but for tabulation approach we can't do like this
        if(arr[0] != 0 && target>= arr[0]) dp[0][arr[0]] = 1;

        for(int i = 1; i<n; i++){
            for (int j = 0; j <= target; j++) {
                int notPick = dp[i-1][j];
                int pick = 0;
                if(j >= arr[i]) pick = dp[i-1][j -arr[i]];
                dp[i][j] = (notPick + pick) % mod;
            }
        }
        return dp[n-1][target];
    }
}
