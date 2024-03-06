package Dynamic_Programming_Striver;

import java.util.Arrays;

public class _33_distinct_subsequences {
    public static void main(String[] args) {
       String s1 = "babgbag";
       String s2 = "bag";
       int i = s1.length();
       int j = s2.length();

        System.out.println(distinct(s1, s2, i-1, j-1));

        int [][] dp = new int[i][j];
        for(int [] a : dp) Arrays.fill(a, -1);
        System.out.println(distinct2(s1, s2, i-1, j-1, dp));

        int [][] Dp = new int[i+1][j+1];
        System.out.println(distinct3(s1, s2, Dp));
    }
    public static int distinct(String s1, String s2, int i, int j){
        if(j<0) return 1;
        if(i<0) return 0;
        if(s1.charAt(i) == s2.charAt(j)){
            return distinct(s1, s2, i-1, j-1) + distinct(s1, s2, i-1, j);
        }
        return distinct(s1, s2, i-1, j);
    }
    public static int distinct2(String s1, String s2, int i, int j, int [][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = distinct2(s1, s2, i-1, j-1, dp) + distinct2(s1, s2, i-1, j, dp);
        }
        return dp[i][j] = distinct2(s1, s2, i-1, j, dp);
    }
    public static int distinct3(String s1, String s2, int [][] dp){
        int n = s1.length();
        int m = s2.length();

        for(int i = 0; i<= n; i++) dp[i][0] = 1;
        for (int i = 1; i <= m; i++) dp[0][i] = 0; // here i is starting from 0 , because if we don't do that this will overwrite the previous loops dp[0][0] to 0

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        for(int [] a : dp){
            for(int b : a) System.out.print(b);
            System.out.println();
        }
        return dp[n][m];
    }
}
