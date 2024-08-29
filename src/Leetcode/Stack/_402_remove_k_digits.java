package Leetcode.Stack;

import java.util.Stack;
//https://leetcode.com/problems/remove-k-digits/

public class _402_remove_k_digits {
    public static void main(String[] args) {
        String num = "1432219";
        System.out.println(removeKdigits(num , 3));
    }

    // TC : O(3n) + O(k)
    // SC : O(n + n) --> for the stack and for the StringBuilder sb
    public static String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char ch : num.toCharArray()){
            while(!stack.isEmpty() && k > 0 && ch <= stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        // removing remaining k digits from the end of the stack
        while(k > 0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }

        // Construct the resulting string from the stack
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse(); // reversing the sb to get the correct order

        // remove leading zeros
        while(!sb.isEmpty() && sb.charAt(0) == '0') sb.deleteCharAt(0);

        // Handle edge case where result might be empty
        return sb.isEmpty() ? "0" : sb.toString();
    }
}
