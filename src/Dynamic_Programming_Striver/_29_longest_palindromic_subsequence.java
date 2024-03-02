package Dynamic_Programming_Striver;

import java.util.Arrays;
// not solved yet
//https://leetcode.com/problems/longest-palindromic-subsequence/description/
public class _29_longest_palindromic_subsequence {
    // the question states , we are given a string , we have to find the longest palindromic subsequence in that string,
    // LPS : a substring which is palindromic
    // one way to do it is find all the subsequences and find the longest palindromic among them
    // and the other way we can do is using the longest common subsequence approach, so if we reverse the original string and try to find the longest common subsequence between them , that will be our answer.
    // how is this working, let's take an example :-
    // String s = subas
    // reverse = sabus , so from these two we can see that if a subsequence is present in both of them that is palindrome, and we need the longest subsequence so no doubt we can apply the LCS approach
    public static void main(String[] args) {
        String s = "bbabcbcab";
        // String s = "subas";
        String reversed = new StringBuilder(s).reverse().toString();
        int length = s.length();
        System.out.println(print(s, reversed, length-1, length-1));

        int [][] dp = new int[length][length];
        for(int [] a : dp) Arrays.fill(a, -1);
        System.out.println(print2(s, reversed, length-1, length-1, dp));

        int [][] Dp = new int[length+1][length+1];
        System.out.println(print3(s, reversed, Dp));
    }
    // longest common palindromic subsequence means the longest string which is present in both the strings and is a palindromic string
    public static int print(String s1, String s2, int ind1, int ind2){
        if(ind1 < 0 || ind2 < 0){
            return 0;
        }
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            return 1 + print(s1, s2, ind1-1, ind2-1);
        }
        return Math.max(print(s1, s2, ind1-1, ind2), print(s1, s2, ind1, ind2-1));
    }

    public static int print2(String s1, String s2, int ind1, int ind2, int [][] dp){
        if(ind1 < 0 || ind2 < 0){
            return 0;
        }
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            return 1 + print2(s1, s2, ind1-1, ind2-1, dp);
        }
        return Math.max(print2(s1, s2, ind1-1, ind2, dp), print2(s1, s2, ind1, ind2-1, dp));
    }
    public static int print3(String s1, String s2, int [][] dp){
        int ind1 = s1.length();
        int ind2 = s2.length();

        for(int i = 0; i <= ind1; i++) dp[i][0] = 0;
        for(int i = 0; i <= ind2; i++) dp[0][i] = 0;

        for(int i = 1; i<= ind1; i++){
            for(int j = 1; j <= ind2; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[ind1][ind2];
    }
}
