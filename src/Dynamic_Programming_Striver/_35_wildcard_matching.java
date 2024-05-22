package Dynamic_Programming_Striver;

import java.util.Arrays;

public class _35_wildcard_matching {
    public static void main(String[] args) {
        String s1 = "a*at";
        String s2 = "chat";
        int i = s1.length();
        int j = s2.length();

        System.out.println(match(s1, s2, i-1, j-1));

        int [][] dp = new int[i][j];
        for(int [] a : dp) Arrays.fill(a, -1);
        System.out.println(match2(s1, s2, i-1, j-1, dp));

        boolean [][] Dp = new boolean[i+1][j+1];
        System.out.println(match3(s1, s2, Dp));
    }


    // for leetcode we have to modify it a little bit
    public static boolean isMatch(String s, String p) {
        return match2(s, p, s.length() -1 , p.length() -1);
    }
    public static boolean match2(String s1, String s2, int i, int j){
        if(i<0 && j<0) return true;

        if(i<0){
            for (int k = 0; k <= j; k++) {
                if(s2.charAt(k) != '*') return false;
            }
            return true;
        }

        if(j<0){
            for (int k = 0; k <= i; k++) {
                if(s1.charAt(k) != '*') return false;
            }
            return true;
        }
        if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?' || s2.charAt(j) == '?') return match2(s1, s2, i-1, j-1);
        if(s1.charAt(i) == '*' || s2.charAt(j) == '*'){
            return match2(s1, s2, i-1,j) || match2(s1, s2, i, j-1);
        }
        return false;
    }
    public static boolean match(String s1, String s2, int i, int j, boolean [][] dp){
        if(i<0 && j<0) return true;

        if(i<0){
            for (int k = 0; k <= j; k++) {
                if(s2.charAt(k) != '*') return false;
            }
            return true;
        }
        if(j<0) return false; // if pattern string is over and main string is not over then we can't match it

        if(dp[i][j]) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?' || s2.charAt(j) == '?'){
            dp[i][j] = match(s1, s2, i-1, j-1, dp);
        }
        else if(s1.charAt(i) == '*' || s2.charAt(j) == '*'){
            dp[i][j] = match(s1, s2, i-1,j, dp) || match(s1, s2, i, j-1, dp);
        }
        return dp[i][j];
    }

    public static boolean match(String s1, String s2, boolean [][] dp){
        int len_s = s1.length();
        int len_p = s2.length();

        dp[0][0] = true;
        for(int i = 1 ; i <= len_s; i++) dp[i][0] = false;
        for(int i = 1; i <= len_p; i++){
            if(s2.charAt(i-1) == '*') dp[0][i] = dp[0][i-1];
        }

        for(int i = 1; i <= len_s; i++){
            for(int j = 1; j <= len_p; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) == '?' || s2.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(s1.charAt(i-1) == '*' || s2.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[len_s][len_p];
    }








    




    // code by striver
    public static boolean match(String s1, String s2, int i, int j){
        if(i<0 && j<0) return true; // if both the string got exhausted which means we got a match
        if(i<0 && j>=0) return false; // s1 is exhausted but s2 is not so there is no match
        // when s2 got exhausted but s1 is not, so we have to check if all the remaining characters are * then we can return true but if one of them is not a * then we will return false
        if(j<0){
            for (int k = 0; k <= i; k++) {
                if(s1.charAt(k) != '*') return false;
            }
            return true;
        }
        if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?') return match(s1, s2, i-1, j-1);
        if(s1.charAt(i) == '*'){
            return match(s1, s2, i-1,j) || match(s1, s2, i, j-1);
        }
        return false;
    }
    public static boolean match2(String s1, String s2, int i, int j, int [][] dp){
        if(i<0 && j<0) return true; // if both the string got exhausted which means we got a match
        if(i<0 && j>=0) return false; // s1 is exhausted but s2 is not so there is no match
        // when s2 got exhausted but s1 is not, so we have to check if all the remaining characters are * then we can return true but if one of them is not a * then we will return false
        if(j<0 && i >= 0){
            for (int k = 0; k <= i; k++) {
                if(s1.charAt(k) != '*') return false;
            }
            return true;
        }
        if(dp[i][j] != -1) return dp[i][j] == 1 ? true : false;
        if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?') {
            boolean match = match2(s1, s2, i-1, j-1, dp);
            if(match) dp[i][j] = 1;
            else dp[i][j] = 0;
            return dp[i][j] == 1;
        }
        if(s1.charAt(i) == '*'){
            boolean match = match2(s1, s2, i-1,j, dp) || match2(s1, s2, i, j-1, dp) ;
            if(match) dp[i][j] = 1;
            else dp[i][j] = 0;
            return dp[i][j] == 1 ;
        }
        return dp[i][j] == 1 ;
    }
    public static boolean match3(String s1, String s2, boolean [][] dp){
        int l1 = s1.length();
        int l2 = s2.length();

        dp[0][0] = true;
        for (int i = 1; i <= l2; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i <= l1; i++) {
            boolean flag = true;
            for (int k = 1; k <= i; k++) {
                if(s1.charAt(k-1) != '*'){
                    flag = false;
                }
            }
            dp[i][0] = flag;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) == '?') dp[i][j] = dp[i-1][j-1];
                else if (s1.charAt(i-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                else dp[i][j] = false;
            }
        }
        return dp[l1][l2];
    }
}
