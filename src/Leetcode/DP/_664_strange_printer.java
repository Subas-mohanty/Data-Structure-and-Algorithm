package Leetcode.DP;

import java.util.Arrays;

// https://leetcode.com/problems/strange-printer/?envType=daily-question&envId=2024-08-21
// https://www.youtube.com/watch?v=pV3arpA0TzY


public class _664_strange_printer {
  int [][] dp = new int[101][101];


    // TC : O(n^3) --> n^2 for recursion and n for loop
    // SC : O(n^2) --> for the dp array
    public int strangePrinter(String s) {
        for(int [] a : dp) Arrays.fill(a, -1);
        return helper(s, 0, s.length()-1, dp);
    }
    int helper(String s, int l, int r, int [][] dp){
        if(l == r) return 1;
        if(l >= r) return 0;

        // find i, i points to a character which is not equal to charAt(l)
        int i = l + 1;
        while(i <= r && s.charAt(l) == s.charAt(i)) i++;
        // if i goes out of bound this means all characters are same, so need only 1 step to print the characters
        if(i == r+1) return 1;

        if(dp[l][r] != -1) return dp[l][r];
        
        // what this basic approac is, first print all the same characters at once, then find the rest answer from the different character to the end
        // the 1 added is for printing the first set of similar characters
        int basic = 1 + helper(s, i, r, dp);

        // what this greed thing is doing is, it is checking if any character same as charAt(l) is present after i 
        // if present then take them to print at once and change the middle characters, and then take min(basic, greed)
        int greed = (int) 1e9;

        // j is going from the diff character to the end, and we are checking if the jth character is same as lth character then calculate for i to j-1 and j to r and then sum it up, find the min of all and at the end return min(basic, greed)
        for(int j = i; j <= r; j++){
            if(s.charAt(j) == s.charAt(l)){
                int res = helper(s, i, j-1, dp) + helper(s, j, r, dp);
                greed = Math.min(res, greed);
            }
        }
        return dp[l][r] = Math.min(basic, greed);
    }
}
