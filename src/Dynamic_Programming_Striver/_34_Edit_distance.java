package Dynamic_Programming_Striver;

import java.util.Arrays;

public class _34_Edit_distance {
    public static void main(String[] args) {
        String s1 = "subas";
        String s2 = "subu";
        int i = s1.length();
        int j = s2.length();

        System.out.println(waysToMakeS1ToS2(s1, s2, i-1, j-1));

        int [][] dp = new int[i][j];
        for (int [] a : dp) Arrays.fill(a, -1);
        System.out.println(helper(s1, s2, i-1, j-1, dp));

        int [][] Dp = new int[i+1][j+1];
        System.out.println(helper2(s1, s2, Dp));
    }
    public static int waysToMakeS1ToS2(String s1, String s2, int i, int j){

        if(j<0) return i+1; // when s2 exhausted, we have to delete the remaining characters in s1, so that will take i+1 operation
        if(i<0) return j+1; // same when s1 got exhausted, we have to add the remaining character of s2 in s1 and that will take j+1 operation

        if(s1.charAt(i) == s2.charAt(j)){
            return  waysToMakeS1ToS2(s1, s2, i-1, j-1);
        }
        else{
            int insert = 1 + waysToMakeS1ToS2(s1, s2, i, j-1);
            int replace = 1 + waysToMakeS1ToS2(s1, s2, i-1, j-1);
            int delete = 1 + waysToMakeS1ToS2(s1, s2, i-1, j);
            return Math.min(Math.min(insert, replace), delete);
        }
    }
    public static int helper(String s1, String s2, int i, int j, int [][] dp){

        if(j<0) return i+1; // when s2 exhausted, we have to delete the remaining characters in s1, so that will take i+1 operation
        if(i<0) return j+1; // same when s1 got exhausted, we have to add the remaining character of s2 in s1 and that will take j+1 operation


        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = helper(s1, s2, i-1, j-1, dp);
        }
        else{
            int insert = 1 + helper(s1, s2, i, j-1, dp);
            int replace = 1 + helper(s1, s2, i-1, j-1, dp);
            int delete = 1 + helper(s1, s2, i-1, j, dp);
            return dp[i][j] = Math.min(Math.min(insert, replace), delete);
        }
    }
    public static int helper2(String s1, String s2, int [][] dp){

        int l1 = s1.length();
        int l2 = s2.length();

        for (int i = 0; i <= l2; i++) dp[0][i] = i;
        for (int j = 0; j <= l1 ; j++) dp[j][0] = j;

        for (int i = 1; i <= l1 ; i++) {
            for (int j = 1; j <= l2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int insert = 1 + dp[i][j-1];
                    int replace = 1 + dp[i-1][j-1];
                    int delete = 1 + dp[i-1][j];
                    dp[i][j] = Math.min(Math.min(insert, replace), delete);
                }
            }
        }
        return dp[l1][l2];
    }
}
