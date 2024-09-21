package Leetcode.Strings;

import java.util.ArrayList;
import java.util.List;

public class _241_diff_ways_to_add_parenthesis {
    // I don't understand it, have to see it again
    // TC : O(3^n)
    // SC : only the recursion stack space
    public List<Integer> diffWaysToCompute(String expression) {
        return helper(expression);
    }
    List<Integer> helper(String s){
        List<Integer> ans = new ArrayList<>();

        // at each operator, check in lef and right, and get the result of left and right and then combine them
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!Character.isDigit(ch)){
                List<Integer> left = helper(s.substring(0, i));
                List<Integer> right = helper(s.substring(i+1));

                // combining the result received from left and right
                for(int l : left){
                    for(int r : right){
                        if(ch == '+') ans.add(l+r);
                        else if(ch == '-') ans.add(l-r);
                        else if(ch == '*') ans.add(l*r);
                    }
                }
            }
        }

        // if the string is only a single number then no addition will have been done so only adding the integer value of the string in the answer
        if(ans.isEmpty()){
            ans.add(Integer.parseInt(s));
        }
        return ans;
    }
}
