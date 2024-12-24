package Leetcode.Array;

import java.util.Arrays;
//https://leetcode.com/problems/find-missing-observations/description/?envType=daily-question&envId=2024-09-05
public class _2028_find_missing_observations {

    // TC : O(len(rolls) + (totalEl * mean) - sum)
    // SC : O(n) --> for the answer array

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int len = rolls.length;
        int sum = 0;
        int totalEl = len + n;

        // O(n)
        for(int a : rolls) sum += a;

        int remain = (totalEl * mean) - sum;


        // we can't make the answer if the sum is greater than n*6
        // because at most we can make sum = n * 6, by filling every cell of the array as 6
        if(remain < n || remain > n * 6) return new int[]{};

        // now calculate which are the numbers need to be taken between 1-6 to make the remain

        int [] ans = new int[n];
        int ind = 0;

        // here we can optimize a lil bit by adding remain/n in each index instead of 1
//        int avg = remain/n;
//        Arrays.fill(ans, avg);
//        remain -= avg * n;

        Arrays.fill(ans, 1);
        remain -= n;

        // O(remain) = (totalEl * mean) - sum;
        while(remain != 0){
            if(ind < n && ans[ind] < 6){
                ans[ind]++;
                remain--;
            }
            else ind++;
        }
        return ans;
    }
}
