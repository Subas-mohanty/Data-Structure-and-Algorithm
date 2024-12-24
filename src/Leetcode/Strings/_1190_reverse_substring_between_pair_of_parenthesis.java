package Leetcode.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/

// youtube explanation of reverseParentheses2
//https://www.youtube.com/watch?v=QaNaaj76T8c&t=802
public class _1190_reverse_substring_between_pair_of_parenthesis {
    public static void main(String[] args) {
        String s = "(abcd)";
        System.out.println(reverseParentheses(s));
        System.out.println(reverseParentheses2(s));
    }

    // TC : O(n)
    // SC : O(3n)
    public static String reverseParentheses2(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int [] arr = new int[n];

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(i);
            }
            else if(ch == ')'){
                // when we fina a closing parenthesis, we are storing its corresponding opening parenthesis in an array
                int openIndex = stack.pop();
                arr[openIndex] = i;
                arr[i] = openIndex;
            }
        }
        // we are taking a direction variable to move in that direction because if there are even number of parenthesis then we don't have to reverse the substring
        int dir = 1;
        int ind = 0;

        while(ind < n){
            char ch = s.charAt(ind);
            if(ch == ')' || ch == '('){
                // when we get a bracket , changing the direction and getting the opening or closing parenthesis
                dir = -1 * dir;
                ind = arr[ind];
            }
            else{
                // otherwise just appending the character in the string builder
                sb.append(ch);
            }

            // moving the index according to the direction
            ind += dir;
        }
        return sb.toString();
    }


    // TC : O(n^2)
    // SC : O(2n)
    public static String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch == '(' || ch != ')'){
                stack.push(ch);
            }
            // ch is ')'
            else {
                List<Character> list = new ArrayList<>();

                while(!stack.isEmpty() && stack.peek() != '('){
                    list.add(stack.pop());
                }
                // removing the top opening bracket
                stack.pop();
                // re inserting the elements
                for(char c : list){
                    stack.push(c);
                }
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
