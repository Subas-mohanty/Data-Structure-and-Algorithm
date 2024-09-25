package Leetcode.DP;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/regular-expression-matching/submissions/
//https://www.youtube.com/watch?v=3vbBrl-LeDc

public class _10_regex_matching {

    // java inbuilt method to check regex matching
    // TC : O(n)
    // SC : O(1)
    // it uses recursive approach, so in the worst case the TC can go upto 2 ^ n
    public boolean isMatch3(String s, String p){
        return s.matches(p);
    }

    // recursive solution
    // TC : O(2 ^ m+n) , it will not be 3^ m+n, because either if case will run or else, and inside if case we are calling the recursion 2 times
    // SC : O(m + n) recursion space
    public boolean isMatch2(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();

        boolean firstCharMatch = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        if(p.length() >= 2 && p.charAt(1) == '*'){
            boolean notTake = isMatch2(s, p.substring(2));
            boolean take = firstCharMatch && isMatch2(s.substring(1), p);
            return take || notTake;
        }
            return firstCharMatch && isMatch2(s.substring(1), p.substring(1));
    }


    // dp solution, memoization
    // TC : O(n * m)
    // TC : O(m * n) + (m + n) recursion stack space
    Map<String, Boolean> map = new HashMap<>();
    public boolean isMatch(String s, String p) {

        String key = s + "," + p;
        if(map.containsKey(key)) return map.get(key);

        if(p.isEmpty()) return s.isEmpty();

        boolean firstCharMatch = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        boolean result;
        if(p.length() >= 2 && p.charAt(1) == '*'){
            boolean notTake = isMatch(s, p.substring(2));
            boolean take = firstCharMatch && isMatch(s.substring(1), p);
            result = take || notTake;
        }
        else{
            result = firstCharMatch && isMatch(s.substring(1), p.substring(1));
        }
        map.put(key, result);

        return result;
    }
}
