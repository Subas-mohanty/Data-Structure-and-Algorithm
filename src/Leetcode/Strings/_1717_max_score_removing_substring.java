package Leetcode.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
//https://shorturl.at/l1sy0
public class _1717_max_score_removing_substring {
    static public int maximumGain(String s, int x, int y) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int ans = 0;
        String top, low;
        int top_s, low_s;

        // getting the max pair value, which one gives more score, ab or ba
        if(x > y){
            top = "ab";
            top_s = x;
            low = "ba";
            low_s = y;
        }
        else{
            top = "ba";
            top_s = y;
            low = "ab";
            low_s = x;
        }

        // first finding all the max score string and calculating the score
        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == top.charAt(0) && ch == top.charAt(1)){
                ans += top_s;
                stack.pop();
            }
            else stack.push(ch);
        }

        // getting all the remaining characters
        List<Character> remainingChars = new ArrayList<>();
        while (!stack.isEmpty()) {
            remainingChars.add(stack.pop());
        }

        // Reverse the remaining characters to maintain original order
        Collections.reverse(remainingChars);

        // calculating the score for the minimum score pair
        for(char ch : remainingChars){
            if(!stack2.isEmpty() && stack2.peek() == low.charAt(0) && ch == low.charAt(1)){
                ans += low_s;
                stack2.pop();
            }
            else{
                stack2.push(ch);
            }
        }
        return ans;
    }
}
