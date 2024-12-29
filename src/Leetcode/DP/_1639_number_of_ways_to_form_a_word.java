package Leetcode.DP;

import java.util.Arrays;
//https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/submissions/1491437783/?envType=daily-question&envId=2024-12-29

public class _1639_number_of_ways_to_form_a_word {

    // absolute brute force
    // what is the thought process ?
    // so we will start at the first index of the first word, then if the character matches with the target[ind] then we move col and ind by 1, means find the next character and we are traversing all words from the next col to find the next character, when we found a character we call recursion to find the next remaining characters
    // what next ?
    // optimize this by using memoization

    // TC : O((w*n) ^ m) --> w = word.length, n = word[0].length and m = target.length
    // SC : recursion space of O(m*n)
    public int numWays(String[] words, String target) {
        return helper(words, target, 0, 0);
    }

    int helper(String[] words, String target, int col, int ind) {
        if (ind == target.length()) return 1;

        int ans = 0;
        int mod = (int) 1e9 + 7;
        // go to each word and at each index, check if the char is matching or not, if matched then find the next char
        for (int i = 0; i < words.length; i++) {
            for (int j = col; j < words[i].length(); j++) {
                if (words[i].charAt(j) == target.charAt(ind)) {
                    ans += helper(words, target, j + 1, ind + 1);
                }
            }
        }
        return ans % mod;
    }


    // better approach - memoization
    // simply memoize the brute force but it gives tle
    // TC : O(n * m * w * n) --> for the loop and the memoization table
    // SC : O(n * m)
//    int [][] dp;
    public int numWays2(String[] words, String target) {
        dp = new int[words[0].length() + 1][target.length()];
        for(int [] a : dp) Arrays.fill(a, -1);
        return helper2(words, target, 0, 0);
    }

    int helper2(String [] words, String target, int col, int ind){
        if(ind == target.length()) return 1;

        int ans = 0;
        int mod = (int)1e9 + 7;
        if(dp[col][ind] != -1 ) return dp[col][ind];
        for(int i = 0; i < words.length; i++){
            for(int j = col; j < words[i].length(); j++){
                if(words[i].charAt(j) == target.charAt(ind)){
                    ans += helper2(words, target, j + 1, ind + 1);
                    ans %= mod;
                }
            }
        }
        return dp[col][ind] = ans;
    }

    // another approach
    // now i thought the second loop is useless, we can find the next column using recursion only and it is already been taken care of by recursion so i can remove it
    // but still it gives tle because time complexity was cubic
    // TC : O(n * m * w) --> for the loop and the memoization table
    // SC : O(n * m)
    int [][] dp;
    public int numWays3(String[] words, String target) {
        dp = new int[words[0].length() + 1][target.length()];
        for(int [] a : dp) Arrays.fill(a, -1);
        return helper3(words, target, 0, 0);
    }

    int helper3(String [] words, String target, int col, int ind){
        if(ind == target.length()) return 1;
        if(col == words[0].length()) return 0;

        int ans = 0;
        int mod = (int)1e9 + 7;
        if(dp[col][ind] != -1 ) return dp[col][ind];
        for(int i = 0; i < words.length; i++){
            // take the character and add to the answer
            if(words[i].charAt(col) == target.charAt(ind)){
                ans += helper3(words, target, col + 1, ind + 1);
                ans %= mod;
            }
        }
        // not take the character, ind is same
        ans += helper3(words, target, col + 1, ind);
        ans %= mod;

        return dp[col][ind] = ans;
    }

    // another approach
    // now we can optimize this by finding the frequency of the characters at each col,
    // if we can do so, we can remove the loop totally, but to find the frequency we are using a loop again which is causing the time to be same
    // TC : O(n * m * w) --> for the loop and the memoization table
    // SC : O(n * m)
//    int [][] dp;
    public int numWays4(String[] words, String target) {
        dp = new int[words[0].length() + 1][target.length()];
        for(int [] a : dp) Arrays.fill(a, -1);
        return helper4(words, target, 0, 0);
    }

    int helper4(String [] words, String target, int col, int ind){
        if(ind == target.length()) return 1;
        if(col == words[0].length()) return 0;

        int ans = 0;
        int mod = (int)1e9 + 7;
        if(dp[col][ind] != -1 ) return dp[col][ind];
        int count = 0;
        // find the frequency of characters at the col
        for(String word : words){
            if(word.charAt(col) == target.charAt(ind)) count++;
        }

        // take case
        if(count > 0){
            // no of possible ways is count * helper(....)
            ans += (int) (((long) count * helper4(words, target, col + 1, ind + 1)) % mod);
        }
        // not take case
        ans += helper4(words, target, col + 1, ind);
        ans %= mod;

        return dp[col][ind] = ans;
    }

    // optimal approach
    // here we are precomputing the frequency, which is removing the extra loop and it is inside our time bound
    // TC : O(n * m + w * m) --> for the frequency table and memoization table time
    // SC : O(n * m + w * m)

//    int [][] dp;
    public int numWays5(String[] words, String target) {
        int n = words[0].length();
        int m = target.length();
        dp = new int[n + 1][m];

        for(int [] a : dp) Arrays.fill(a, -1);

        int [][] freq = new int[n][26];

        for(String s : words){
            for(int i = 0; i < n; i++){
                int chval = s.charAt(i) - 'a';
                freq[i][chval]++;
            }
        }
        return helper5(freq, target, 0, 0);
    }

    int helper5(int [][] freq, String target, int col, int ind){
        if(ind == target.length()) return 1;
        if(col == freq.length) return 0;

        int ans = 0;
        int mod = (int)1e9 + 7;

        if(dp[col][ind] != -1 ) return dp[col][ind];

        int chval = target.charAt(ind) - 'a';
        int count = freq[col][chval];

        // take case
        if(count > 0){
            ans += (int) ((1l * count * helper5(freq, target, col + 1, ind + 1)) % mod);
        }
        // not take case
        ans += helper5(freq, target, col + 1, ind);
        ans %= mod;

        return dp[col][ind] = ans;
    }
}
