package Dynamic_Programming_Striver;

//https://leetcode.com/problems/longest-common-subsequence/
// DSA-01 : 27-02-2024

import java.util.Arrays;

public class _26_Longest_Common_Subsequence {
    public static void main(String[] args) {
        String s1 = "bbabc";
        String s2 = "bacb";
        int length1 = s1.length();
        int length2 = s2.length();
        System.out.println(lcs(s1, s2, length1 - 1, length2 - 1));

        int [][] dp = new int[length1][length2];
        for(int []  a : dp) Arrays.fill(a, -1);
        System.out.println(lcs2(s1, s2, length1 - 1, length2 - 1, dp));

        int [][] Dp = new int[length1+1][length2+1];
        System.out.println(lcs4(s1, s2, Dp));

        int [][] ans = new int[length1+1][length2+1];
        System.out.println(f(s1, s2, Dp, length1,length2));
    }


    public static int f(String s1, String s2, int [][] dp, int l1, int l2) {
        for (int i = 1; i <= l1 ; i++) {
            for (int j = 1; j <= l2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        for(int [] a : dp){
            System.out.println(Arrays.toString(a));
        }
        return dp[l1][l2];
    }



    // TC : 2^n * 2^m --> which is exponential
    // SC : O(m+n) --> for the recursion stack , we put one index as same and move the other one till the start so
    public static int lcs(String s1, String s2, int ind1, int ind2){
        if(ind1 < 0 || ind2 < 0) return 0;
        // match case : found a subsequences of length 1 now if we find more subsequences in the string we will add it
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            return 1 + lcs(s1, s2, ind1 - 1, ind2 - 1);
        }
        return Math.max(lcs(s1, s2, ind1 - 1, ind2), lcs(s1, s2, ind1, ind2 - 1));
    }

    // TC : O(m*n)
    // SC : O(m*n) + O(m+n) --> dp array and the recursion stack space
    public static int lcs2(String s1, String s2, int ind1, int ind2, int [][] dp){
        if(ind1 < 0 || ind2 < 0) return 0;
        // match case : found a subsequences of length 1 now if we find more subsequences in the string we will add it
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            return 1 + lcs2(s1, s2, ind1 - 1, ind2 - 1, dp);
        }
        return dp[ind1][ind2] = Math.max(lcs2(s1, s2, ind1 - 1, ind2, dp), lcs2(s1, s2, ind1, ind2 - 1, dp));
    }

    // in this function we are shifting the indexes so, we will pass n and m instead of n-1 and m-1, and also we have to declare the dp array of size n+1 and m+1
    public static int lcs3(String s1, String s2, int ind1, int ind2, int [][] dp){
        // now both the index will be 0 instead of -1
        if(ind1 == 0 || ind2 == 0) return 0;
        // match case : found a subsequences of length 1 now if we find more subsequences in the string we will add it
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        if(s1.charAt(ind1-1) == s2.charAt(ind2-1)){
            return 1 + lcs3(s1, s2, ind1 - 1, ind2 - 1, dp);
        }
        return dp[ind1][ind2] = Math.max(lcs3(s1, s2, ind1 - 1, ind2, dp), lcs3(s1, s2, ind1, ind2 - 1, dp));
    }
    // here also we are using 1 based indexing like the above memoization one
    public static int lcs4(String s1, String s2, int [][] dp){
        int l1 = s1.length();
        int l2 = s2.length();

        for(int i = 0; i <= l2; i++) dp[0][i] = 0; // when index1 = 0 we have to fill for all values of string s2 so, we took l2 and vice-versa for index2 = 0
       for(int i = 0; i <= l1; i++) dp[i][0] = 0;

       for (int i = 1; i <= l1; i++) {
           for (int j = 1; j <= l2; j++) {
               if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
               }
               else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
           }
        }
       return dp[l1][l2];
    }
}
