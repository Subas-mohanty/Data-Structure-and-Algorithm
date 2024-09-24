package Leetcode.DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/extra-characters-in-a-string/description/?envType=daily-question&envId=2024-09-23


public class _2707_extra_characters_in_string {
    int [] dp = new int[51];
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        Arrays.fill(dp, -1);
        // using set for faster searching
        for(String str : dictionary) set.add(str);
        return helper(s, set, 0);
    }
    int helper(String s, Set<String> set, int ind){
        if(ind == s.length()) return 0;

        if(dp[ind] != -1) return dp[ind];
        int take = (int)1e9;
        int not = (int)1e9;
        int ans = (int)1e9;

        StringBuilder sb = new StringBuilder();
        for(int i = ind; i < s.length(); i++){
            // creating substring
            sb.append(s.charAt(i));
            // if the substring is not present in the set, then the number of unused character is the length of the substring and then find from the next character with recursion call
            if(!set.contains(sb.toString())){
                take = sb.length() + helper(s, set, i+1);
            }
            // if the substring is present then number of unused character is 0, so no need to add anything just check from the next character
            // return the min of them
            else not = helper(s, set, i+1);
            ans = Math.min(ans, Math.min(take, not));
        }

        return dp[ind] = ans;
    }
}
