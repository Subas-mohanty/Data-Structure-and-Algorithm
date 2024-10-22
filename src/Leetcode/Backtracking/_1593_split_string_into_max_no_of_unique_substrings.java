package Leetcode.Backtracking;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/?envType=daily-question&envId=2024-10-21

public class _1593_split_string_into_max_no_of_unique_substrings {

    // TC : O(n * 2^n) --> loop will run for n times and the recursion call will happen for 2^n, no of substrings time
    // SC : O(2^n) --> in the worst case all the substrings of String s can be unique and the set will store all the substrings
    int maxScore;
    public int maxUniqueSplit(String s) {
        maxScore = 0;
        helper(0, s, new HashSet<>());
        return maxScore;
    }
    void helper(int ind, String s, Set<String> set){
        int n = s.length();
        if(ind == n){
            maxScore = Math.max(maxScore, set.size());
            return;
        }
        for(int i = ind; i < n; i++){
            String sub = s.substring(ind, i+1);
            if(!set.contains(sub)){
                set.add(sub);
                helper(i + 1, s, set); // till i we have taken the substring so now take from i + 1
                set.remove(sub); // removing the substring to backtrack
            }
        }
    }
}
